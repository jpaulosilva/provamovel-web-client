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
    
     $url = 'http://ivanknow.koding.io/workspace/projetows/server/serverrest/questao.json';

    echo file_get_contents($url);
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
			
			
			
        echo json_encode(array('error'=>'0','token'=>$accessToken,'email'=>$email));
       
       
}catch(PDOException $e){
			echo json_encode(array('error'=>'1','mensagem'=>$e->getMessage()));
	}

            
        }
        else{
             echo json_encode(array('error'=>'1','mensagem'=>'Usuario não encontrado'));
        }
       
}catch(PDOException $e){
			
         
          echo json_encode(array('error'=>'1','mensagem'=>$e->getMessage()));
	}
    
    
    
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
			
			
			
       echo json_encode(array('error'=>'0','token'=>$accessToken,'email'=>$email));
}catch(PDOException $e){
	    
	    echo json_encode(array('error'=>'1','mensagem'=>$e->getMessage()));
	}
    
    
    
    
    
    
}
?>