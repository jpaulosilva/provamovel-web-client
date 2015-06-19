<?php
require_once("lib/nusoap.php");

//using soap_server to create server object
$server    = new soap_server;
$server->configureWSDL('provamovel');

//register a function that works on server
$server->register("login",array("email" => "xsd:string","senha" => "xsd:string"),array("return" => "xsd:string"),"urn:provamovel");

$server->register("cadastrar",array("email" => "xsd:string","senha" => "xsd:string","cep" => "xsd:string"),array("return" => "xsd:string"),"urn:provamovel");


function login($email,$senha)
{
   //TODO
    $result = "token";
    return $result;
}

function cadastrar($email,$senha,$cep)
{
   //TODO
    $result = "token";
    return $result;
}
// create HTTP listener
$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';
$server->service($HTTP_RAW_POST_DATA);

?>
