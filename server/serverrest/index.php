<?php
date_default_timezone_set ( "America/Recife" );

include 'Slim/Slim.php';
\Slim\Slim::registerAutoloader ();
$app = new \Slim\Slim ();
$app->get ( '/questao/', 'getQuestao' );
$app->get ( '/login/facebook/:token', 'loginFacebook' );
$app->get ( '/cadastro/facebook/:token', 'cadastroFacebook' );


$app->run ();
function getQuestao() {
	$retorno = array ("error"=>"teste");
	
	echo json_encode ( $retorno );
}

function loginFacebook($token) {
	$retorno = array ("error"=>"TODO");
	
	echo json_encode ( $retorno );
}

function cadastroFacebook() {
	$retorno = array ("error"=>"TODO");
	
	echo json_encode ( $retorno );
}
?>