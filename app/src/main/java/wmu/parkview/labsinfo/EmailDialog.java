package wmu.parkview.labsinfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This dialog gets receiver's email address and all details for the current qr string before
 * opening user's email app with a ready to send email
 */
public class EmailDialog extends DialogFragment {
    private EditText mEmail;

    private ListActivity mListActivity;
    private List<HashMap<String, String>> mAllDetails;
    private ArrayList<Uri> mPicUris;
    private int mPicUrisExpectedSize;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View dialog = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_email, null);
        mEmail = dialog.findViewById(R.id.edit_text_email);

        mListActivity = (ListActivity) getActivity();

        return new AlertDialog.Builder(getActivity()).setView(dialog).setPositiveButton(
                R.string.open_email_app, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mAllDetails = DBHelper.getAllDetails(getContext(),
                                EmailDialog.this, null);
                    }
                }).create();
    }

    /**
     * Expects to be called by DBHelper when all details loaded from database are ready to use
     */
    void allDetailsLoadedForEmail() {
        mPicUrisExpectedSize = 0;

        for (int i = 0; i < mAllDetails.size(); i++)
            if (!mAllDetails.get(i).get("address").startsWith("https://www.youtube.com/watch?v=") &&
                    !mAllDetails.get(i).get("address").equals(""))
                mPicUrisExpectedSize++;

        if (mPicUrisExpectedSize != 0) {
            mPicUris = getPicUris();
        } else {
            picUrisLoaded();
        }
    }
    
    /**
     * Expects to be called when URIs for all pics have been loaded into 'mPicUris'
     */
    private void picUrisLoaded() {
        Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { mEmail.getText().toString() });
        intent.putExtra(Intent.EXTRA_SUBJECT, "WMU CEAS Tour - " + DBHelper.currentQRString);
        intent.putExtra(Intent.EXTRA_TEXT, getEmailText(mAllDetails));
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, mPicUris);
        mListActivity.startActivity(intent);
    }

    /**
     * Turns information from received list into a formatted string ready to be added as text in
     * email
     * @param allDetails a list of key value pairs with keys 'title', 'description' and 'address'
     * @return a formatted string
     */
    String getEmailText(List<HashMap<String, String>> allDetails) {
        StringBuilder sBuilder = new StringBuilder("Dear Future Bronco,\n\n We are really " +
                "excited that you are considering WMU!\n\nHere are some " +
                "details about ").append(DBHelper.currentQRString).append(":\n");

        boolean extraNewLineNeeded = false;

        for (int i = 0; i < allDetails.size(); i++) {
            if (!(i > 0 && allDetails.get(i).get("title").equals(allDetails.get(i - 1).
                    get("title")))) {
                if (extraNewLineNeeded) sBuilder.append("\n");
                extraNewLineNeeded = true;

                sBuilder.append("\n").append(allDetails.get(i).get("title")).append("\n");
            }

            if (allDetails.get(i).get("address").startsWith("https://www.youtube.com/watch?v=")) {
                sBuilder.append("YouTube Link: ").append(allDetails.get(i).get("address")).
                        append("\n");
                extraNewLineNeeded = true;
            }

            if (!allDetails.get(i).get("description").equals("")) {
                sBuilder.append(allDetails.get(i).get("description")).append("\n\n");
                extraNewLineNeeded = false;
            }
        }

        sBuilder.append("\nRegards,\nWMU CEAS Tours Team");

        return sBuilder.toString();
    }

    /**
     * Stores all pictures referenced in 'mAllDetails' into cache
     * @return the list which will contain URIs for all pics
     */
    private ArrayList<Uri> getPicUris() {
        ArrayList<Uri> picUris = new ArrayList<>();

        for (int i = 0; i < mAllDetails.size(); i++) {
            if (!mAllDetails.get(i).get("address").startsWith("https://www.youtube.com/watch?v=") &&
                    !mAllDetails.get(i).get("address").equals("")) {
                String picName = mAllDetails.get(i).get("address").substring(mAllDetails.get(i).
                        get("address").lastIndexOf('/') + 1, mAllDetails.get(i).get("address").
                        lastIndexOf('.'));

                Glide.with(mListActivity).asBitmap().load(mAllDetails.get(i).get("address")).into(
                        new CustomTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(@NonNull Bitmap resource, @Nullable
                                    Transition<? super Bitmap> transition) {
                                try {
                                    File file = new File(mListActivity.getCacheDir(), picName
                                            + ".jpg");
                                    if (file.exists()) file.delete();

                                    FileOutputStream fOutStream = new FileOutputStream(file);
                                    resource.compress(Bitmap.CompressFormat.JPEG, 100,
                                            fOutStream);
                                    fOutStream.flush();
                                    fOutStream.close();

                                    picUris.add(FileProvider.getUriForFile(mListActivity,
                                            "wmu.parkview.labsinfo.fileprovider", file));

                                    if (mPicUris.size() == mPicUrisExpectedSize) picUrisLoaded();
                                } catch (Exception e) {
                                    Toast.makeText(mListActivity, R.string.email_picture_error,
                                            Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onLoadCleared(@Nullable Drawable placeholder) {}
                        });
            }
        }

        return picUris;
    }
}