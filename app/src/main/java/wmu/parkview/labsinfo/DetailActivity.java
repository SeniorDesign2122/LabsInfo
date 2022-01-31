package wmu.parkview.labsinfo;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

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

    /**
     * Adds a YouTube player to the linear layout and loads a YouTube video in it
     * @param identifier identifier of the YouTube video to load
     */
    private void addVideo(String identifier) {
        YouTubePlayerView youTubeView = new YouTubePlayerView(this);
        youTubeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubeView.initialize("AIzaSyDeXhr4cc1LFn6u6yPqI_sErEJE9JJmu2Y",
                        new YouTubePlayer.OnInitializedListener() {
                            @Override
                            public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                                YouTubePlayer youTubePlayer,
                                                                boolean b) {
                                youTubePlayer.setShowFullscreenButton(false);
                                youTubePlayer.loadVideo(identifier);
                            }

                            @Override
                            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                                YouTubeInitializationResult
                                                                        youTubeInitializationResult)
                            {
                                Toast.makeText(DetailActivity.this, R.string.video_error,
                                        Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
        mLVLayout.addView(youTubeView);
    }
}
