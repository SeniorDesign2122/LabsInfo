package wmu.parkview.labsinfo;

import android.content.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * This class contains methods that get info from PHP files stored on server
 */
public class DBHelper {
    static String currentQRString;

    /**
     * Gets all the qr strings from database
     * @param context context of the application
     * @param testing if unit testing, expected to contain only one element with its value set to
     *                true; null otherwise
     * @return a set of qr strings
     */
    static Set<String> getQRStrings(Context context, boolean[] testing) {
        return null;
    }

    /**
     * Gets details for all the entries from database that match the 'currentQRString' and
     * received 'title'
     * @param context context of the application
     * @param title the title string in database to which the query should be restricted to
     * @param testing if unit testing, expected to contain only one element with its value set to
     *                true; null otherwise
     * @return a list of key value pairs with keys 'description' and 'address'
     */
    static List<HashMap<String, String>> getDetails(Context context, String title,
                                                    boolean[] testing) {
        return null;
    }

    /**
     * Gets details for all the entries from database that match the 'currentQRString'
     * @param context context of the application
     * @param emailDialog calling instance of the EmailDialog class
     * @param testing if unit testing, expected to contain only one element with its value set to
     *                true; null otherwise
     * @return a list of key value pairs with keys 'title', 'description' and 'address'
     */
    static List<HashMap<String, String>> getAllDetails(Context context, EmailDialog emailDialog,
                                                       boolean[] testing) {
        return null;
    }
}