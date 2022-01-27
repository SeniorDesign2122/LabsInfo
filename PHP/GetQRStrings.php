<?php
require_once('Config.php');

/**
 * Gets all the qr strings from database
 * @return array contains qr strings
 */
function getQRStrings() {
    $conn = new PDO(DBCONNSTRING, DBUSER, DBPASS);

    $res = $conn->query("SELECT DISTINCT qr_string FROM labs_info");

    $qRStrings = array();

    while ($row = $res->fetch()) {
        array_push($qRStrings, $row['qr_string']);
    }

    return $qRStrings;
}

echo json_encode(getQRStrings());