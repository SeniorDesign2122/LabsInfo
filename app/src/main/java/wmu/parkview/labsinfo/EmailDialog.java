package wmu.parkview.labsinfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

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
        return null;
    }
}
