<?php

/**
 * This class contains tests for functions that we use to get info from our database
 */
class AllTest extends \PHPUnit\Framework\TestCase {

    /**
     * This function tests getTitle() for all titles stored under qr string 'Unit Testing'
     */
    function testGetTitles() {
        require_once('GetTitles.php');

        $expected = array("Case A", "Case B", "Case C", "Case D", "Case E", "Case F", "Case G", "Case H", "Case I",
            "Case J", "Case K", "Case L", "Case M");

        $this->assertSame($expected, getTitles("Unit Testing"));
    }
    
    /**
     * This functions tests getDetails() with various combinations of the following:
     * - description without picture or video
     * - picture without description
     * - video without description
     * - picture with description
     * - video with description
     */
    function testGetDetails() {
        require_once('GetDetails.php');

        // Case A
        $expected = array();

        array_push($expected, array('description'=>"Description for Unit Testing / Case A - No Picture / Video.",
            'address'=>""));

        $this->assertSame($expected, getDetails("Unit Testing", "Case A"));

        // Case B
        $expected = array();

        array_push($expected, array('description'=>"",
            'address'=>"http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet Traverse.jpeg"));

        $this->assertSame($expected, getDetails("Unit Testing", "Case B"));

        // Case C
        $expected = array();

        array_push($expected, array('description'=>"",
            'address'=>"https://www.youtube.com/watch?v=9tobL8U7dQo"));

        $this->assertSame($expected, getDetails("Unit Testing", "Case C"));

        // Case D
        $expected = array();

        array_push($expected, array('description'=>"Description for Unit Testing / Case D - GMC Sierra.",
            'address'=>"http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/GMC Sierra.jpeg"));

        $this->assertSame($expected, getDetails("Unit Testing", "Case D"));

        // Case E
        $expected = array();

        array_push($expected, array('description'=>"Description for Unit Testing / Case E - Celebrating Steve.",
            'address'=>"https://www.youtube.com/watch?v=CeSAjK2CBEA"));

        $this->assertSame($expected, getDetails("Unit Testing", "Case E"));

        // Case F
        $expected = array();

        array_push($expected, array('description'=>"",
            'address'=>"http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet Silverado.jpeg"));

        array_push($expected, array('description'=>"",
            'address'=>"https://www.youtube.com/watch?v=XKfgdkcIUxw"));

        array_push($expected, array('description'=>"Description for Unit Testing / Case F - No Picture / Video.",
            'address'=>""));

        $actual = getDetails("Unit Testing", "Case F");

        $this->assertSame(count($expected), count($actual));

        $this->assertTrue($expected[0] === $actual[0] or $expected[1] === $actual[0]);
        $this->assertTrue($expected[0] === $actual[1] or $expected[1] === $actual[1]);

        $this->assertSame($expected[2], $actual[2]);

        // Case G
        $expected = array();

        array_push($expected, array('description'=>"Description for Unit Testing / Case G - " .
            "Apple Watch Series 7.",
            'address'=>"https://www.youtube.com/watch?v=MMdQ-gWBNZE"));

        array_push($expected, array('description'=>"Description for Unit Testing / Case G - Chevrolet Equinox.",
            'address'=>"http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet Equinox.jpeg"));

        array_push($expected, array('description'=>"Description for Unit Testing / Case G - No Picture / Video.",
            'address'=>""));

        $this->assertSame($expected, getDetails("Unit Testing", "Case G"));

        // Case H
        $expected = array();

        array_push($expected, array('description'=>"",
            'address'=>"https://cdn.vox-cdn.com/thumbor/Qz4JriwqoF--DwDdVZQPuALxNek=/1400x1400/filters:format(jpeg)/" .
                "cdn.vox-cdn.com/uploads/chorus_asset/file/22526630/2_16x9.jpg"));

        array_push($expected, array('description'=>"Description for Unit Testing / Case H - No Picture / Video.",
            'address'=>""));

        $this->assertSame($expected, getDetails("Unit Testing", "Case H"));

        // Case I
        $expected = array();

        array_push($expected, array('description'=>"",
            'address'=>"https://www.youtube.com/watch?v=74SDT7NfxCg&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=2"));

        array_push($expected, array('description'=>"Description for Unit Testing / Case I - No Picture / Video.",
            'address'=>""));

        $this->assertSame($expected, getDetails("Unit Testing", "Case I"));

        // Case J
        $expected = array();

        array_push($expected, array('description'=>"",
            'address'=>"https://www.topgear.com/sites/default/files/cars-car/image/2018/05/ford_2018_fiesta_st_3door" .
                "_02.jpg"));

        array_push($expected, array('description'=>"",
            'address'=>"https://www.youtube.com/watch?v=RowCRlt80xI&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=4"));

        $actual = getDetails("Unit Testing", "Case J");

        $this->assertSame(count($expected), count($actual));

        $this->assertTrue($expected[0] === $actual[0] or $expected[1] === $actual[0]);
        $this->assertTrue($expected[0] === $actual[1] or $expected[1] === $actual[1]);

        // Case K
        $expected = array();

        array_push($expected, array('description'=>"Description for Unit Testing / Case K - Ford Focus.",
            'address'=>"https://cdn.motor1.com/images/mgl/4yv4K/s1/ford-focus-st-edition-front.jpg"));

        array_push($expected, array('description'=>"Description for Unit Testing / Case K - No Picture / Video.",
            'address'=>""));

        $this->assertSame($expected, getDetails("Unit Testing", "Case K"));

        // Case L
        $expected = array();

        array_push($expected, array('description'=>"Description for Unit Testing / Case L - Galaxy Z Fold3: " .
            "Water resistance.",
            'address'=>"https://www.youtube.com/watch?v=xyljYr5rcKI&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=10"));

        array_push($expected, array('description'=>"Description for Unit Testing / Case L - No Picture / Video.",
            'address'=>""));

        $this->assertSame($expected, getDetails("Unit Testing", "Case L"));

        // Case M
        $expected = array();

        array_push($expected, array('description'=>"Description for Unit Testing / Case M - Ford Mustang.",
            'address'=>"https://www.ford.com/is/image/content/dam/brand_ford/en_us/brand/cars/mustang/brand_mustang/" .
                "dm/21_FRD_MST_wdmp_200510_00360.tif?croppathe=1_3x2&wid=1440"));

        array_push($expected, array('description'=>"Description for Unit Testing / Case M - Galaxy Z Fold3: " .
            "Multitasking.",
            'address'=>"https://www.youtube.com/watch?v=n_k-BZ6sKFI&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=14"));

        $this->assertSame($expected, getDetails("Unit Testing", "Case M"));
    }

    /**
     * This functions tests getAllDetails() with various combinations of the following:
     * - description without picture or video
     * - picture without description
     * - video without description
     * - picture with description
     * - video with description
     */
    function testGetAllDetails() {
        require_once('GetAllDetails.php');

        $expected = array();

        // Case A
        array_push($expected, array('title'=>"Case A",
            'description'=>"Description for Unit Testing / Case A - No Picture / Video.",
            'address'=>""));

        // Case B
        array_push($expected, array('title'=>"Case B",
            'description'=>"",
            'address'=>"http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet Traverse.jpeg"));

        // Case C
        array_push($expected, array('title'=>"Case C",
            'description'=>"",
            'address'=>"https://www.youtube.com/watch?v=9tobL8U7dQo"));

        // Case D
        array_push($expected, array('title'=>"Case D",
            'description'=>"Description for Unit Testing / Case D - GMC Sierra.",
            'address'=>"http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/GMC Sierra.jpeg"));

        // Case E
        array_push($expected, array('title'=>"Case E",
            'description'=>"Description for Unit Testing / Case E - Celebrating Steve.",
            'address'=>"https://www.youtube.com/watch?v=CeSAjK2CBEA"));

        // Case F
        array_push($expected, array('title'=>"Case F",
            'description'=>"",
            'address'=>"http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet Silverado.jpeg"));

        array_push($expected, array('title'=>"Case F",
            'description'=>"",
            'address'=>"https://www.youtube.com/watch?v=XKfgdkcIUxw"));

        array_push($expected, array('title'=>"Case F",
            'description'=>"Description for Unit Testing / Case F - No Picture / Video.",
            'address'=>""));

        // Case G
        array_push($expected, array('title'=>"Case G",
            'description'=>"Description for Unit Testing / Case G - Apple Watch Series 7.",
            'address'=>"https://www.youtube.com/watch?v=MMdQ-gWBNZE"));

        array_push($expected, array('title'=>"Case G",
            'description'=>"Description for Unit Testing / Case G - Chevrolet Equinox.",
            'address'=>"http://mshop.cs.wmich.edu/tablet/Pics/Unit Testing/Chevrolet Equinox.jpeg"));

        array_push($expected, array('title'=>"Case G",
            'description'=>"Description for Unit Testing / Case G - No Picture / Video.",
            'address'=>""));

        // Case H
        array_push($expected, array('title'=>"Case H",
            'description'=>"",
            'address'=>"https://cdn.vox-cdn.com/thumbor/Qz4JriwqoF--DwDdVZQPuALxNek=/1400x1400/filters:format(jpeg)/" .
                "cdn.vox-cdn.com/uploads/chorus_asset/file/22526630/2_16x9.jpg"));

        array_push($expected, array('title'=>"Case H",
            'description'=>"Description for Unit Testing / Case H - No Picture / Video.",
            'address'=>""));

        // Case I
        array_push($expected, array('title'=>"Case I",
            'description'=>"",
            'address'=>"https://www.youtube.com/watch?v=74SDT7NfxCg&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=2"));

        array_push($expected, array('title'=>"Case I",
            'description'=>"Description for Unit Testing / Case I - No Picture / Video.",
            'address'=>""));

        // Case J
        array_push($expected, array('title'=>"Case J",
            'description'=>"",
            'address'=>"https://www.topgear.com/sites/default/files/cars-car/image/2018/05/ford_2018_fiesta_st_3door" .
                "_02.jpg"));

        array_push($expected, array('title'=>"Case J",
            'description'=>"",
            'address'=>"https://www.youtube.com/watch?v=RowCRlt80xI&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=4"));

        // Case K
        array_push($expected, array('title'=>"Case K",
            'description'=>"Description for Unit Testing / Case K - Ford Focus.",
            'address'=>"https://cdn.motor1.com/images/mgl/4yv4K/s1/ford-focus-st-edition-front.jpg"));

        array_push($expected, array('title'=>"Case K",
            'description'=>"Description for Unit Testing / Case K - No Picture / Video.",
            'address'=>""));

        // Case L
        array_push($expected, array('title'=>"Case L",
            'description'=>"Description for Unit Testing / Case L - Galaxy Z Fold3: Water resistance.",
            'address'=>"https://www.youtube.com/watch?v=xyljYr5rcKI&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=10"));

        array_push($expected, array('title'=>"Case L",
            'description'=>"Description for Unit Testing / Case L - No Picture / Video.",
            'address'=>""));

        // Case M
        array_push($expected, array('title'=>"Case M",
            'description'=>"Description for Unit Testing / Case M - Ford Mustang.",
            'address'=>"https://www.ford.com/is/image/content/dam/brand_ford/en_us/brand/cars/mustang/brand_mustang/" .
                "dm/21_FRD_MST_wdmp_200510_00360.tif?croppathe=1_3x2&wid=1440"));

        array_push($expected, array('title'=>"Case M",
            'description'=>"Description for Unit Testing / Case M - Galaxy Z Fold3: Multitasking.",
            'address'=>"https://www.youtube.com/watch?v=n_k-BZ6sKFI&list=PLhpbZcOKxtO2e57UXV2tU3CHEfPA2O8co&index=14"));

        $actual = getAllDetails("Unit Testing");

        $this->assertSame(count($expected), count($actual));

        for ($i = 0; $i < 5; $i++) {
            $this->assertSame($expected[$i], $actual[$i]);
        }

        $this->assertTrue($expected[5] === $actual[5] or $expected[6] === $actual[5]);
        $this->assertTrue($expected[5] === $actual[6] or $expected[6] === $actual[6]);

        for ($i = 7; $i < 15; $i++) {
            $this->assertSame($expected[$i], $actual[$i]);
        }

        $this->assertTrue($expected[15] === $actual[15] or $expected[16] === $actual[15]);
        $this->assertTrue($expected[15] === $actual[16] or $expected[16] === $actual[16]);

        for ($i = 17; $i < count($expected); $i++) {
            $this->assertSame($expected[$i], $actual[$i]);
        }
    }

}