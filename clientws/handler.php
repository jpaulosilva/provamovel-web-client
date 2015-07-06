<?php

//soap
include("../server/serversoap/lib/nusoap.php");

$urlsoap = "http://ivanknow.koding.io/workspace/projetows/server/serversoap/server.php?wsdl";

$urlrest = "http://ivanknow.koding.io/workspace/projetows/server/serverrest/";

$requisicao = $_REQUEST;

$client = new soapclient($urlsoap);

switch ($requisicao['operacao']) {
    case 'login':
        echo $client->login($requisicao['email'],$requisicao['password']);
        break;
    case 'loginfacebook':
        $requests = file_get_contents($urlrest."/login/facebook/".$requisicao['accesstoken']);
        print_r($requests);
        break;
    case 'cadastro':

       $retorno = $client->cadastrar($requisicao['email'],$requisicao['password'],$requisicao['cep']);
        
        break;
    case 'cadastrofacebook':
         $requests = file_get_contents($urlrest."/cadastro/facebook/".$requisicao['accesstoken']);
        print_r($requests);
        break;
    default:
        // code...
        break;
}

?>