<?php
require_once("lib/nusoap.php");
include ("../app/Conexao.php");
//using soap_server to create server object
$server    = new soap_server;
$server->configureWSDL('provamovel');

//register a function that works on server
$server->register("login",array("email" => "xsd:string","senha" => "xsd:string"),array("return" => "xsd:string"),"urn:provamovel");

$server->register("cadastrar",array("email" => "xsd:string","senha" => "xsd:string","cep" => "xsd:string"),array("return" => "xsd:string"),"urn:provamovel");


function login($email,$senha)
{
    try{
	
	$con = new Conexao();
       

			$sql = "select * from tb_usuario where email = '$email' and senha = '$senha'";
			
			$con->connect();
            $stmt = $con->query($sql);
			
			$array = array();
			foreach ($stmt as $row)
			{
			$array[] = $row;
			}
        
			$con->desconnect();
        if (count($array) == 1)
            return $array[0]['token'];
        else
            return "error";
       
}catch(PDOException $e){
			echo $e->getMessage();
	}
    return "error";
}

function cadastrar($email,$senha,$cep)
{
   try{
	
	$con = new Conexao();
       
            
            $token = md5($email.$senha);
            

			$cmd = "insert into tb_usuario (email,senha,cep,token)  values('$email','$senha','$cep','$token')";
			
			$con->connect();
            $con->exec($cmd);
			$con->desconnect();
       return $token;
}catch(PDOException $e){
			echo $e->getMessage();
	}
    return "error";
}
// create HTTP listener
$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';
$server->service($HTTP_RAW_POST_DATA);

?>
