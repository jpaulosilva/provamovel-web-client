<?php
require_once("lib/nusoap.php");
include ("../app/Conexao.php");

$server    = new soap_server;
$server->configureWSDL('provamovel');


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
            return   "{'token':'".$array[0]['token']."',error:0}";
        else
            return "{'error':'1','message':'User not found','sql':'$sql'}";
       
}catch(PDOException $e){
			 return "{'error':'1','message':'".$e->getMessage()."'}";
	}
    
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
			
			$retorno = getEndereco($cep);
			
			$cmd2 = "insert into tb_endereco (cep,rua,cidade,estado)  values('".$cep."','".$retorno->logradouro."','".$retorno->cidade."','".$retorno->uf."')";
			$con->connect();
            $con->exec($cmd2);
			$con->desconnect();
			
       return "{'token':'$token',error:0}";
       
}catch(PDOException $e){
			 return "{'error':'1','message':'".$e->getMessage()."'}";
	}
   
}


function getEndereco($numcep){
$client = new soapclient("http://cep.paicon.com.br/ws/cep.asmx?WSDL");

$consultar = array("cep"=>$numcep);

$result    =    $client->Consultar($consultar);


return $result->ConsultarResult;
}

$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';
$server->service($HTTP_RAW_POST_DATA);

?>
