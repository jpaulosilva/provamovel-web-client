<?php
include("lib/nusoap.php");
$client = new soapclient("http://localhost/workspace/nusoap-0.9.5/server3.php?wsdl");

$functions = $client->__getFunctions ();
var_dump ($functions);
$result    =    $client->hello();
echo "<pre>";
print_r($result);
echo "</pre>";


?>
