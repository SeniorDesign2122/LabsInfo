<?php
require_once('Config.php');

/**
 * Gets details for all the entries from database that match the received 'qRString' and 'title'
 * @param string $qRString the qr string string in database to which the query should be restricted to
 * @param string $title the title string in database to which the query should be restricted to
 * @return array an associative array with keys 'description' and 'address'
 */
function getDetails($qRString, $title) {
    $conn = new PDO(DBCONNSTRING, DBUSER, DBPASS);

    $res = $conn->prepare("SELECT description, address FROM labs_info WHERE qr_string = ? AND title = ? ORDER BY description");
    $res->execute(array($qRString, $title));

    $details = array();

    while ($row = $res->fetch()) {
        array_push($details, array('description'=>$row['description'], 'address'=>$row['address']));
    }

    return $details;
}

if (isset($_REQUEST['qr_string']) and isset($_REQUEST['title'])) {
    echo json_encode(getDetails($_REQUEST['qr_string'], $_REQUEST['title']));
}