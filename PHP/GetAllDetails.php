<?php
require_once('Config.php');

/**
 * Gets details for all the entries from database that match the 'qRString'
 * @param string $qRString the qr string in database to which the query should be restricted to
 * @return array an associative array with keys 'title', 'description' and 'address'
 */
function getAllDetails($qRString) {
    $conn = new PDO(DBCONNSTRING, DBUSER, DBPASS);

    $res = $conn->prepare("SELECT title, description, address FROM labs_info WHERE qr_string = ? ORDER BY title, description");
    $res->execute(array($qRString));

    $entries = array();

    while ($row = $res->fetch()) {
        array_push($entries, array('title'=>$row['title'], 'description'=>$row['description'],
            'address'=>$row['address']));
    }

    return $entries;
}

if (isset($_REQUEST['qr_string'])) {
    echo json_encode(getAllDetails($_REQUEST['qr_string']));
}