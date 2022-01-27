package wmu.parkview.labsinfo;

import androidx.fragment.app.DialogFragment;

import java.util.HashMap;
import java.util.List;

/**
 * This dialog gets receiver's email address and all details for the current qr string before
 * opening user's email app with a ready to send email
 */
public class EmailDialog extends DialogFragment {

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