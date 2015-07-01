<?php
include("lib/nusoap.php");
$client = new soapclient("http://localhost/workspace/projetows/provamovel-web-client/server/serversoap/server.php?wsdl");


$functions = $client->__getFunctions ();
var_dump ($functions);

$result    =    $client->cadastrar("ivan@gmail.com","123456","52011270");
print_r ($result);
?>
