<?php

$url = 'https://android.googleapis.com/gcm/send';

$registration_id = 'XXXXXXXXXXXXXXXXXXXX'; //registration IDはここ
$message = 'test message!';

$header = array(
  'Content-Type: application/x-www-form-urlencoded;charset=UTF-8',
  'Authorization: key=XXXXXXXXXXXXXXXX', //API keyはここ
);
$post_list = array(
  'registration_id' => $registration_id,
  'collapse_key' => 'update',
  'data.message' => $message,
);
$post = http_build_query($post_list, '&');

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_FAILONERROR, 1);
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);
curl_setopt($ch, CURLOPT_POST, TRUE);
curl_setopt($ch, CURLOPT_HTTPHEADER, $header);
curl_setopt($ch, CURLOPT_POSTFIELDS, $post);
curl_setopt($ch, CURLOPT_TIMEOUT, 5);
$ret = curl_exec($ch);
 
var_dump($ret);
