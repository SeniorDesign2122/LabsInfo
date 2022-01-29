package wmu.parkview.labsinfo;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * This class contains methods that get info from PHP files stored on server
 */
public class DBHelper {
    private final static String DIRECTORY = "http://mshop.cs.wmich.edu/tablet/PHP/";

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
     * Gets all the titles for 'currentQRString' from database
     * @param context context of the application
     * @param testing if unit testing, expected to contain only one element with its value set to
     *                true; null otherwise
     * @return a list of titles
     */
    static List<String> getTitles(Context context, boolean[] testing) {
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
        List<HashMap<String, String>> details = new ArrayList<>();

        StringRequest request = new StringRequest(Request.Method.GET, DIRECTORY +
                "GetDetails.php?qr_string=" + currentQRString + "&title=" + title,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);

                                HashMap<String, String> detail = new HashMap<>();
                                detail.put("description", object.getString("description"));
                                detail.put("address", object.getString("address"));

                                details.add(detail);
                            }

                            if (testing == null) {
                                ((DetailActivity) context).detailsLoaded();
                            } else {
                                testing[0] = false;
                            }
                        } catch (Exception e) {
                            Toast.makeText(context, R.string.get_db_data_error,
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, R.string.db_connect_error, Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(context).add(request);

        return details;
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