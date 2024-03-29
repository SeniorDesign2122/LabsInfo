package wmu.parkview.labsinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.zxing.Result;

import java.util.Set;

/**
 * This activity scans a qr code and passes it to a new ListActivity if a match exists in database
 */
public class ScanActivity extends AppCompatActivity {
    private final int CAMERA_PERMISSION_CODE = 1;

    private CodeScanner mCodeScanner;

    private Set<String> mQRStrings;
    private boolean mCamPermissionGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        mCodeScanner = new CodeScanner(this, findViewById(R.id.scanner));

        mCodeScanner.setScanMode(ScanMode.CONTINUOUS);

        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                if (mQRStrings.contains(result.getText())) {
                    Intent intent = new Intent(ScanActivity.this, ListActivity.class);
                    intent.putExtra("qRString", result.getText());
                    startActivity(intent);
                }
            }
        });

        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            mCamPermissionGranted = false;
            requestPermissions(new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
        } else {
            mCamPermissionGranted = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mCamPermissionGranted = true;
                mCodeScanner.startPreview();
            } else {
                mCamPermissionGranted = false;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mQRStrings = DBHelper.getQRStrings(this, null);
        if (mCamPermissionGranted) mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }
}