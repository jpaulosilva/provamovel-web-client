<?php


$urlrest = "http://ivanknow.koding.io/workspace/projetows/server/serverrest/";

$retorno = file_get_contents($urlrest."questao");
        
$array = json_decode($retorno);

//print_r($array->items);
        
echo "<br>Prova:".$array->items[0]->titulo;
echo "<br>Professor:".$array->items[0]->autor;  
echo "<br>Data:".$array->items[0]->data; 

 
 foreach ($array->items[0]->questoes as $q) {
     echo "<br>".$q->titulo;
    echo "<ul>";

    foreach ($q->alternativas as $alt) {
    
     echo "<li><input type='radio'>".$alt->titulo."</input></li>";
     
    }  
    echo "</ul>"; 
 }

        
?>

<a href="index.php">Voltar</a>