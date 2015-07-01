<?php
date_default_timezone_set ( "America/Recife" );

include 'Slim/Slim.php';
include ("../app/Conexao.php");
\Slim\Slim::registerAutoloader ();
$app = new \Slim\Slim ();
$app->get ( '/questao/', 'getQuestao' );
$app->get ( '/login/facebook/:accessToken', 'loginFacebook' );
$app->get ( '/cadastro/facebook/:accessToken', 'cadastroFacebook' );


$app->run ();
function getQuestao() {
	$retorno = array ("error"=>"teste");
	
	echo json_encode ( $retorno );
}

function loginFacebook($accessToken) {
    
    $url = 'https://graph.facebook.com/me?access_token='.$accessToken;


$requests = file_get_contents($url);

$teste = json_decode($requests);


$facebook_id =   $teste->id;
$email = $teste->email;   
    
     try{
	
	$con = new Conexao();
       

			$sql = "select * from tb_usuario where email = '$email' and facebook_id = '$facebook_id'";
			
			$con->connect();
            $stmt = $con->query($sql);
			
			$array = array();
			foreach ($stmt as $row)
			{
			$array[] = $row;
			}
        
			$con->desconnect();
        if (count($array) == 1){
            
            
             try{
	
	$con = new Conexao();
    
            

			$cmd = "update tb_usuario set token='$accessToken' where facebook_id = '$facebook_id'";
			
			$con->connect();
            $con->exec($cmd);
			$con->desconnect();
			
			
			
       echo "{'sucesso':'true','accesstoken':'".$accessToken."'}";
}catch(PDOException $e){
			echo "{'sucesso':'false', 'mensagem':'".$e->getMessage()."'}";
	}
            
            
            
            echo $array[0]['token'];
            
        }
        else
            echo "{'sucesso':'false'}";
         
       
}catch(PDOException $e){
			
         
         echo "{'sucesso':'false', 'mensagem':'".$e->getMessage()."'}";
	}
    
    
    
    
    
    
    
    
	/*$retorno = array ("error"=>"TODO");
	
	echo json_encode ( $retorno );*/
}

function cadastroFacebook($accessToken) {
	
    $url = 'https://graph.facebook.com/me?access_token='.$accessToken;


$requests = file_get_contents($url);
/*//stdClass Object ( [id] => 1446657805654551 [email] => ivanknowandroidtv@gmail.com [first_name] => Chew [gender] => male [last_name] => Sullivan [link] => https://www.facebook.com/app_scoped_user_id/1446657805654551/ [locale] => pt_BR [name] => Chew Sullivan [timezone] => -3 [updated_time] => 2015-06-19T22:30:36+0000 [verified] => 1 ) */
$teste = json_decode($requests);


$facebook_id =   $teste->id;
$email = $teste->email;   
    
      try{
	
	$con = new Conexao();
    
            

			$cmd = "insert into tb_usuario (email,facebook_id,token)  values('$email','$facebook_id','$accessToken')";
			
			$con->connect();
            $con->exec($cmd);
			$con->desconnect();
			
			
			
       echo "{'sucesso':'true','accesstoken':'".$accessToken."'}";
}catch(PDOException $e){
			 echo "{'sucesso':'false', 'mensagem':'".$e->getMessage()."'}";
	}
    
    
    
    
    
    
}
?>