<?php

class Conexao{
public $host = "localhost";
public $user = "root";
public $password = "";
public $database = "provamovel";
public $conn = null;

public function connect (){
	$this->conn = new PDO("mysql:host=".$this->host.";dbname=".$this->database, $this->user, $this->password);
}

public function desconnect (){
	$this->conn = null;
}

public function exec($cmd){
	 
    return $this->conn->exec($cmd);

}


public function query($cmd){
	return $this->conn->query($cmd);
}

}




	

?>