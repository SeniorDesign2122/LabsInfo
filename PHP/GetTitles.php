<?php
require_once('Config.php');

/**
 * Gets all the titles for 'qRString' from database along with their thumbnails
 * @param string $qRString the qr string in database to which the query should be restricted to
 * @return array an associative array with keys 'title' and 'thumb_address'
 */
function getTitles($qRString) {
    $conn = new PDO(DBCONNSTRING, DBUSER, DBPASS);

    $infoRes = $conn->prepare("SELECT DISTINCT title FROM labs_info WHERE qr_string = ? ORDER BY title");
    $infoRes->execute(array($qRString));

    $titles = array();

    while ($row = $infoRes->fetch()) {
        $thumbRes = $conn->prepare("SELECT address FROM thumbnails WHERE qr_string = ? AND title = ?");
        $thumbRes->execute(array($qRString, $row['title']));

        if ($thumbRes->rowCount() == 0) {
            array_push($titles, array('title'=>$row['title'], 'thumb_address'=>""));
        } else {
            array_push($titles, array('title'=>$row['title'], 'thumb_address'=>$thumbRes->fetch()['address']));
        }
    }

    return $titles;
}

if (isset($_REQUEST['qr_string'])) {
    echo json_encode(getTitles($_REQUEST['qr_string']));
}