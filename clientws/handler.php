<?php

//soap
include("../server/serversoap/lib/nusoap.php");

$urlsoap = "http://ivanknow.koding.io/workspace/projetows/server/serversoap/server.php?wsdl";

$urlrest = "http://ivanknow.koding.io/workspace/projetows/server/serverrest/";

$requisicao = $_REQUEST;

$client = new soapclient($urlsoap);

switch ($requisicao['operacao']) {
    case 'login':
        
       $retorno =  $client->login($requisicao['email'],$requisicao['password']);
        
         echo $retorno;
        $array = json_decode($retorno);
     
        if($array->error == "0"){
            echo "<p>login efetuado com sucesso</p> ";
        } else{
            echo "<p> erro no login</p>";
        }
        
        echo "<a href='index.php'>Voltar ao index</a>";
        
        
        break;
    case 'loginfacebook':
        $retorno = file_get_contents($urlrest."/login/facebook/".$requisicao['accesstoken']);
        
        echo $retorno;
        $array = json_decode($retorno);
     
        if($array->error == "0"){
            echo "<p>login pelo facebook efetuado com sucesso</p> ";
        } else{
            echo "<p> erro no login</p>";
        }
        
        echo "<a href='index.php'>Voltar ao index</a>";
        
        break;
    case 'cadastro':
        
        
       $retorno = $client->cadastrar($requisicao['email'],$requisicao['password'],$requisicao['cep']);
        echo $retorno;
        $array = json_decode($retorno);
     
        if($array->error == "0"){
            echo "<p>cadastro efetuado com sucesso</p> ";
        } else{
            echo "<p> erro no cadastro</p>";
        }
        
        echo "<a href='index.php'>Voltar ao index</a>";
        
        
        break;
    case 'cadastrofacebook':
         $retorno = file_get_contents($urlrest."/cadastro/facebook/".$requisicao['accesstoken']);
        print_r($retorno);
        
        $array = json_decode($retorno);
     
        if($array->error == "0"){
            echo "<p>cadastro pelo facebook efetuado com sucesso</p> ";
        } else{
            echo "<p> erro no cadastro</p>";
        }
        
        echo "<a href='index.php'>Voltar ao index</a>";
        
        break;
    default:
        // code...
        break;
}

?>