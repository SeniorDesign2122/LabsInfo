package wmu.parkview.labsinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class contains tests for methods in DBHelper class
 */
public class DBHelperTest {

    /**
     * This method tests getDetails() with various combinations of the following:
     * - description without picture or video
     * - picture without description
     * - video without description
     * - picture with description
     * - video with description
     */
    @Test
    public void getDetails() {
        boolean[] testing = new boolean[1];
        List<HashMap<String, String>> expected;
        List<HashMap<String, String>> actual;
        HashMap<String, String> detail;
        DBHelper.currentQRString = "Unit Testing";

        // Case A
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case A - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case A",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case B
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "");
        detail.put("address", "http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet " +
                "Traverse.jpeg");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case B",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case C
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "");
        detail.put("address", "https://www.youtube.com/watch?v=9tobL8U7dQo");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case C",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case D
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case D - GMC Sierra.");
        detail.put("address", "http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/GMC Sierra.jpeg");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case D",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case E
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case E - Celebrating Steve.");
        detail.put("address", "https://www.youtube.com/watch?v=CeSAjK2CBEA");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case E",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case F
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "");
        detail.put("address", "http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet " +
                "Silverado.jpeg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "");
        detail.put("address", "https://www.youtube.com/watch?v=XKfgdkcIUxw");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case F - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case F",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());

        assertTrue(expected.get(0).equals(actual.get(0)) ||
                expected.get(1).equals(actual.get(0)));
        assertTrue(expected.get(0).equals(actual.get(1)) ||
                expected.get(1).equals(actual.get(1)));

        assertEquals(expected.get(2), actual.get(2));

        // Case G
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case G - Apple Watch Series 7.");
        detail.put("address", "https://www.youtube.com/watch?v=MMdQ-gWBNZE");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case G - Chevrolet Equinox.");
        detail.put("address", "http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet " +
                "Equinox.jpeg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case G - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case G",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case H
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "");
        detail.put("address", "https://cdn.vox-cdn.com/thumbor/Qz4JriwqoF--DwDdVZQPuALxNek=/" +
                "1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/" +
                "22526630/2_16x9.jpg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case H - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case H",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case I
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "");
        detail.put("address", "https://www.youtube.com/watch?v=74SDT7NfxCg&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=2");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case I - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case I",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case J
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "");
        detail.put("address", "https://www.topgear.com/sites/default/files/cars-car/image/2018/" +
                "05/ford_2018_fiesta_st_3door_02.jpg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "");
        detail.put("address", "https://www.youtube.com/watch?v=RowCRlt80xI&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=4");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case J",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());

        assertTrue(expected.get(0).equals(actual.get(0)) ||
                expected.get(1).equals(actual.get(0)));
        assertTrue(expected.get(0).equals(actual.get(1)) ||
                expected.get(1).equals(actual.get(1)));

        // Case K
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case K - Ford Focus.");
        detail.put("address", "https://cdn.motor1.com/images/mgl/4yv4K/s1/ford-focus-st-edition-" +
                "front.jpg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case K - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case K",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case L
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case L - Galaxy Z Fold3: Water " +
                "resistance.");
        detail.put("address", "https://www.youtube.com/watch?v=xyljYr5rcKI&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=10");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case L - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case L",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));

        // Case M
        expected = new ArrayList<>();

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case M - Ford Mustang.");
        detail.put("address", "https://www.ford.com/is/image/content/dam/brand_ford/en_us/brand/" +
                "cars/mustang/brand_mustang/dm/21_FRD_MST_wdmp_200510_00360.tif?croppathe=1_3x2&" +
                "wid=1440");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("description", "Description for Unit Testing / Case M - Galaxy Z Fold3: " +
                "Multitasking.");
        detail.put("address", "https://www.youtube.com/watch?v=n_k-BZ6sKFI&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=14");
        expected.add(detail);

        testing[0] = true;

        actual = DBHelper.getDetails(ApplicationProvider.getApplicationContext(), "Case M",
                testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));
    }

    /**
     * This method tests getAllDetails() with various combinations of the following:
     * - description without picture or video
     * - picture without description
     * - video without description
     * - picture with description
     * - video with description
     */
    @Test
    public void getAllDetails() {
        HashMap<String, String> detail;

        List<HashMap<String, String>> expected = new ArrayList<>();

        // Case A
        detail = new HashMap<>();
        detail.put("title", "Case A");
        detail.put("description", "Description for Unit Testing / Case A - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        // Case B
        detail = new HashMap<>();
        detail.put("title", "Case B");
        detail.put("description", "");
        detail.put("address", "http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet " +
                "Traverse.jpeg");
        expected.add(detail);

        // Case C
        detail = new HashMap<>();
        detail.put("title", "Case C");
        detail.put("description", "");
        detail.put("address", "https://www.youtube.com/watch?v=9tobL8U7dQo");
        expected.add(detail);

        // Case D
        detail = new HashMap<>();
        detail.put("title", "Case D");
        detail.put("description", "Description for Unit Testing / Case D - GMC Sierra.");
        detail.put("address", "http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/GMC Sierra.jpeg");
        expected.add(detail);

        // Case E
        detail = new HashMap<>();
        detail.put("title", "Case E");
        detail.put("description", "Description for Unit Testing / Case E - Celebrating Steve.");
        detail.put("address", "https://www.youtube.com/watch?v=CeSAjK2CBEA");
        expected.add(detail);

        // Case F
        detail = new HashMap<>();
        detail.put("title", "Case F");
        detail.put("description", "");
        detail.put("address", "http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet " +
                "Silverado.jpeg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case F");
        detail.put("description", "");
        detail.put("address", "https://www.youtube.com/watch?v=XKfgdkcIUxw");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case F");
        detail.put("description", "Description for Unit Testing / Case F - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        // Case G
        detail = new HashMap<>();
        detail.put("title", "Case G");
        detail.put("description", "Description for Unit Testing / Case G - Apple Watch Series 7.");
        detail.put("address", "https://www.youtube.com/watch?v=MMdQ-gWBNZE");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case G");
        detail.put("description", "Description for Unit Testing / Case G - Chevrolet Equinox.");
        detail.put("address", "http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet " +
                "Equinox.jpeg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case G");
        detail.put("description", "Description for Unit Testing / Case G - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        // Case H
        detail = new HashMap<>();
        detail.put("title", "Case H");
        detail.put("description", "");
        detail.put("address", "https://cdn.vox-cdn.com/thumbor/Qz4JriwqoF--DwDdVZQPuALxNek=/" +
                "1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/" +
                "22526630/2_16x9.jpg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case H");
        detail.put("description", "Description for Unit Testing / Case H - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        // Case I
        detail = new HashMap<>();
        detail.put("title", "Case I");
        detail.put("description", "");
        detail.put("address", "https://www.youtube.com/watch?v=74SDT7NfxCg&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=2");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case I");
        detail.put("description", "Description for Unit Testing / Case I - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        // Case J
        detail = new HashMap<>();
        detail.put("title", "Case J");
        detail.put("description", "");
        detail.put("address", "https://www.topgear.com/sites/default/files/cars-car/image/2018/" +
                "05/ford_2018_fiesta_st_3door_02.jpg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case J");
        detail.put("description", "");
        detail.put("address", "https://www.youtube.com/watch?v=RowCRlt80xI&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=4");
        expected.add(detail);

        // Case K
        detail = new HashMap<>();
        detail.put("title", "Case K");
        detail.put("description", "Description for Unit Testing / Case K - Ford Focus.");
        detail.put("address", "https://cdn.motor1.com/images/mgl/4yv4K/s1/ford-focus-st-edition-" +
                "front.jpg");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case K");
        detail.put("description", "Description for Unit Testing / Case K - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        // Case L
        detail = new HashMap<>();
        detail.put("title", "Case L");
        detail.put("description", "Description for Unit Testing / Case L - Galaxy Z Fold3: Water " +
                "resistance.");
        detail.put("address", "https://www.youtube.com/watch?v=xyljYr5rcKI&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=10");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case L");
        detail.put("description", "Description for Unit Testing / Case L - No Picture / Video.");
        detail.put("address", "");
        expected.add(detail);

        // Case M
        detail = new HashMap<>();
        detail.put("title", "Case M");
        detail.put("description", "Description for Unit Testing / Case M - Ford Mustang.");
        detail.put("address", "https://www.ford.com/is/image/content/dam/brand_ford/en_us/brand/" +
                "cars/mustang/brand_mustang/dm/21_FRD_MST_wdmp_200510_00360.tif?croppathe=1_3x2&" +
                "wid=1440");
        expected.add(detail);

        detail = new HashMap<>();
        detail.put("title", "Case M");
        detail.put("description", "Description for Unit Testing / Case M - Galaxy Z Fold3: " +
                "Multitasking.");
        detail.put("address", "https://www.youtube.com/watch?v=n_k-BZ6sKFI&list=" +
                "PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=14");
        expected.add(detail);

        boolean[] testing = new boolean[1];
        testing[0] = true;

        DBHelper.currentQRString = "Unit Testing";

        List<HashMap<String, String>> actual = DBHelper.getAllDetails(
                ApplicationProvider.getApplicationContext(), null, testing);

        while (testing[0]);

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < 5; i++) assertEquals(expected.get(i), actual.get(i));

        assertTrue(expected.get(5).equals(actual.get(5)) ||
                expected.get(6).equals(actual.get(5)));
        assertTrue(expected.get(5).equals(actual.get(6)) ||
                expected.get(6).equals(actual.get(6)));

        for (int i = 7; i < 15; i++) assertEquals(expected.get(i), actual.get(i));

        assertTrue(expected.get(15).equals(actual.get(15)) ||
                expected.get(16).equals(actual.get(15)));
        assertTrue(expected.get(15).equals(actual.get(16)) ||
                expected.get(16).equals(actual.get(16)));

        for (int i = 17; i < expected.size(); i++) assertEquals(expected.get(i), actual.get(i));
    }

}