package wmu.parkview.labsinfo;

import com.google.android.youtube.player.YouTubeBaseActivity;

/**
 * This activity gets details for the current qr string and the title received as an extra and
 * adds them to its linear layout
 */
public class DetailActivity extends YouTubeBaseActivity {

    /**
     * Expects to be called by DBHelper when details loaded from database are ready to use
     */
    void detailsLoaded() {

    }

}