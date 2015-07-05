<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/jquery.mobile-1.4.5.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/Facebook.js"></script>

</head>
<body>
	<div id="login" data-role="page">
		<div data-role="header" data-position="fixed">
		
		</div>
		<div role="main" class="ui-content">
		<form method="GET" action="handler.php">
		<label for="email" class="ui-hidden-accessible">E-mail</label>
				<input type="email" name="textEmail" id="textEmail" value=""
					placeholder="E-mail">
					
		<label for="password" class="ui-hidden-accessible">Senha</label>
				<input type="password" name="textPassword" id="textPassword" value=""
					placeholder="Senha">
		
		<input type="submit"  data-icon="check" class="ui-btn ui-corner-all" data-iconpos="right" name="submit" value="Entrar"></input>
		</form>
		<h1>OU Faça login pelo facebook: <fb:login-button scope="public_profile,email"  onlogin="checkLoginState();">
        </fb:login-button></h1>
		
		
		</div>
		<div data-role="footer" data-position="fixed"> </div>
	</div>
</body>
</html>