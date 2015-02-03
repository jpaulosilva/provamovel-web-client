<?php
date_default_timezone_set ( "America/Recife" );

include 'Slim/Slim.php';
\Slim\Slim::registerAutoloader ();
$app = new \Slim\Slim ();
$app->post ( '/prova/', 'getAllProva' );
$app->post ( '/prova/:id', 'getProvaById' );
//$app->get ( '/prova/:id', 'getProvaById' );
$app->post ( '/login/', 'login' );
$app->post ( '/finalizar/', 'finalizarProva' );

$app->run ();
function getAllProva() {
	$retorno = array (
			"items" => array (
					array (
							"titulo" => "Entretenimento",
							"id" => "1" 
					),
					array (
							"titulo" => "Super-herois",
							"id" => "2" 
					) 
			)
			 
	);
	
	echo json_encode ( $retorno );
}
function getProvaById($id) {
	$prova1 = array (
			"item" => array (
					"titulo" => "Entretenimento",
					"id" => "1",
					"data" => "15/02/2015",
					"autor" => "Ivan",
					"questoes" => array (
							array (
									"enunciado" => "Quem eh o diretor do filme o hobbit?","tipo"=>1,
									"alternativas" => array("Pitter Jackson","Orlando Bloom","Wiliam Bonner","Jorge Lucas")
							),
							array (
									"enunciado" => "Em que pais a serie lost foi filmada?","tipo"=>0 
							),
							array (
									"enunciado" => "Quem eh o diretor do filme o Matrix Reload?","tipo"=>1,
									"alternativas" => array("Pitter Jackson","Orlando Bloom","Wiliam Bonner","Jorge Lucas")
							),
					) 
			)
			 
	);
	
	$prova2 = array (
			"item" => array (
					"titulo" => "Super-herois",
					"id" => "2",
					"data" => "15/02/2015",
					"autor" => "Ivan Rodrigues",
					"questoes" => array (
							array (
									"enunciado" => "Quem eh o tio do Homem-Aranha?","tipo"=>1,
									"alternativas" => array("Tio Bem","Tio Jon","Doende Verde","Jorge Lucas")
							),
							array (
									"enunciado" => "Qual desses nao eh inimigo do Batman","tipo"=>1,
									"alternativas" => array("Bane","Tio Jon","Coringa","Duas caras")
							)
					)
			)
	
	);
	
	$provasEstaticas = array (1=>$prova1,2=>$prova2); 
	$retorno = $provasEstaticas[$id];
	
	echo json_encode ( $retorno );
}

function login() {
	$email = $_POST['login'];
	$password = $_POST['password'];
	//fazer busca
		if($email == "ivanknow@gmail.com" && $password == "123456"){
	//salva hash no banco
			$hash = sha1($email.$password);
	//retorna hash
			$retorno = array("hash"=>$hash,"error"=>0);
		}else{
			$retorno = array("error"=>1,"errorMessage"=>"Erro no login, verifique seus dados");
		}
	echo json_encode ( $retorno );
}

function finalizarProva() {
	$email = $_POST['login'];
	$hash = $_POST['hash'];
	$provaId = $_POST['prova']['provaId'];
	if (isset($_POST['prova']['respostas'])) {
		$respostas = $_POST['prova']['respostas'];
	}else{
		$respostas = array();
	}
	//$respostaString = json_decode($_POST['respostas']);
	if($email == "ivanknow@gmail.com"){//comparar hash
		$string =  "insert into tabela_resposta (usuario,idprova,idquestao,resposta) values ";

		foreach ($respostas as $key => $value) {
			$string .= " ('".$email."','".$provaId."','".$key."','".$value."'), ";
		}
		
		$retorno = array("error"=>0,"string"=>$string);
	}else{
		$retorno = array("error"=>1,"errorMessage"=>"Erro");
	}
	echo json_encode ( $retorno );
}
?>