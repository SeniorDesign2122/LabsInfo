package wmu.parkview.labsinfo;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * This class contains test(s) for method(s) in EmailDialog class
 */
public class EmailDialogTest {

    /**
     * This method tests getEmailText() with various combinations of the following:
     * - description without picture or video
     * - picture without description
     * - video without description
     * - picture with description
     * - video with description
     */
    @Test
    public void getEmailText() {
        boolean[] testing = new boolean[1];
        testing[0] = true;
        DBHelper.currentQRString = "Unit Testing";

        List<HashMap<String, String>> allDetails = DBHelper.getAllDetails(ApplicationProvider.
                getApplicationContext(), null, testing);

        while (testing[0]);

        String actual = new EmailDialog().getEmailText(allDetails);

        String expected = "Dear Future Bronco,\n" +
                "\n" +
                " We are really excited that you are considering WMU!\n" +
                "\n" +
                "Here are some details about Unit Testing:\n" +
                "\n" +
                "Case A\n" +
                "Description for Unit Testing / Case A - No Picture / Video.\n" +
                "\n" +
                "\n" +
                "Case B\n" +
                "\n" +
                "\n" +
                "Case C\n" +
                "YouTube Link: https://www.youtube.com/watch?v=9tobL8U7dQo\n" +
                "\n" +
                "\n" +
                "Case D\n" +
                "Description for Unit Testing / Case D - GMC Sierra.\n" +
                "\n" +
                "\n" +
                "Case E\n" +
                "YouTube Link: https://www.youtube.com/watch?v=CeSAjK2CBEA\n" +
                "Description for Unit Testing / Case E - Celebrating Steve.\n" +
                "\n" +
                "\n" +
                "Case F\n" +
                "YouTube Link: https://www.youtube.com/watch?v=XKfgdkcIUxw\n" +
                "Description for Unit Testing / Case F - No Picture / Video.\n" +
                "\n" +
                "\n" +
                "Case G\n" +
                "YouTube Link: https://www.youtube.com/watch?v=MMdQ-gWBNZE\n" +
                "Description for Unit Testing / Case G - Apple Watch Series 7.\n" +
                "\n" +
                "Description for Unit Testing / Case G - Chevrolet Equinox.\n" +
                "\n" +
                "Description for Unit Testing / Case G - No Picture / Video.\n" +
                "\n" +
                "\n" +
                "Case H\n" +
                "Description for Unit Testing / Case H - No Picture / Video.\n" +
                "\n" +
                "\n" +
                "Case I\n" +
                "YouTube Link: https://www.youtube.com/watch?v=74SDT7NfxCg&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=2\n" +
                "Description for Unit Testing / Case I - No Picture / Video.\n" +
                "\n" +
                "\n" +
                "Case J\n" +
                "YouTube Link: https://www.youtube.com/watch?v=RowCRlt80xI&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=4\n" +
                "\n" +
                "\n" +
                "Case K\n" +
                "Description for Unit Testing / Case K - Ford Focus.\n" +
                "\n" +
                "Description for Unit Testing / Case K - No Picture / Video.\n" +
                "\n" +
                "\n" +
                "Case L\n" +
                "YouTube Link: https://www.youtube.com/watch?v=" +
                "xyljYr5rcKI&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=10\n" +
                "Description for Unit Testing / Case L - Galaxy Z Fold3: Water resistance.\n" +
                "\n" +
                "Description for Unit Testing / Case L - No Picture / Video.\n" +
                "\n" +
                "\n" +
                "Case M\n" +
                "Description for Unit Testing / Case M - Ford Mustang.\n" +
                "\n" +
                "YouTube Link: https://www.youtube.com/watch?v=" +
                "n_k-BZ6sKFI&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=14\n" +
                "Description for Unit Testing / Case M - Galaxy Z Fold3: Multitasking.\n" +
                "\n" +
                "\n" +
                "Regards,\n" +
                "WMU CEAS Tours Team";

        assertEquals(expected, actual);
    }

}