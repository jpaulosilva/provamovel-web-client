<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery.min.js"></script>
<script src="js/Facebook.js"></script>

</head>
<body>
	
		<form method="GET" action="handler.php">
		<input type="hidden" name="operacao" value="cadastro"/>
		<label for="email" >E-mail</label>
				<input type="email" name="email" id="email" value="" />
					
		<label for="password" >Senha</label>
				<input type="password" name="password" id="password" value=""/>
				
		<label for="cep" >CEP</label>
				<input type="cep" name="cep" id="cep" value=""/>
		
		<input type="submit"  name="submit" value="Entrar"></input>
		</form>
		
		
		<h1>
		OU Faça login pelo facebook: 
		<fb:login-button scope="public_profile,email,location"  onlogin="checkLoginState();"> </fb:login-button>
		</h1>
		
		<form method="GET" action="handler.php">
		<input type="hidden" name="operacao" value="cadastroFacebook"/>
		<label for="email" >Access Token</label>
				<input type="text" name="accesstoken" id="accesstoken" value="" />
					
		<input type="submit"  name="submit" value="Entrar"></input>
		</form>
</body>
</html>