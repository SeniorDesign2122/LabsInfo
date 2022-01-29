<?php
require_once('Config.php');

/**
 * Gets all the titles for 'qRString' from database
 * @param string $qRString the qr string in database to which the query should be restricted to
 * @return array contains titles
 */
function getTitles($qRString) {
    $conn = new PDO(DBCONNSTRING, DBUSER, DBPASS);

    $res = $conn->prepare("SELECT DISTINCT title FROM labs_info WHERE qr_string = ? ORDER BY title");
    $res->execute(array($qRString));

    $titles = array();

    while ($row = $res->fetch()) {
        array_push($titles, $row['title']);
    }

    return $titles;
}

if (isset($_REQUEST['qr_string'])) {
    echo json_encode(getTitles($_REQUEST['qr_string']));
}