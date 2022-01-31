package wmu.parkview.labsinfo;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.HashMap;
import java.util.List;

/**
 * This activity gets details for the current qr string and the title received as an extra and
 * adds them to its linear layout
 */
public class DetailActivity extends YouTubeBaseActivity {
    private LinearLayout mLVLayout;

    private List<HashMap<String, String>> mDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mLVLayout = findViewById(R.id.detail_vertical_layout);

        mDetails = DBHelper.getDetails(this, getIntent().getStringExtra("title"),
                null);
    }

    /**
     * Expects to be called by DBHelper when details loaded from database are ready to use
     */
    void detailsLoaded() {

    }

}
