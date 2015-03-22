LoginController = {
	login : "",
	password : "",
	hash : "",
	init : function() {
		// atribui ação ao botão de logar
		$(document).off("click", "#btnLogin").on("click", "#btnLogin",
				LoginController.login);
		// href="home.html"
	},
	login : function() {
		// pega dados
		LoginController.login = $('#textEmail').val().trim();
		LoginController.password = $('#textPassword').val().trim();
		try {
			LoginController.validate();
			LoginController.ajax(LoginController.login,
					LoginController.password);
		} catch (err) {
			alert(err);
		}
	},
	ajax : function(login, password) {
		var values = {
			beforeSend : function() {
				$.mobile.loading('show');
			}, // Show spinner
			complete : function() {
				$.mobile.loading('hide');
			}, // Hide spinner
			type : "POST",
			dataType : "json",
			url : Values.server + "mobile/login/",
			data : "login=" + login + "&password=" + password,
			success : LoginController.onSuccess,
			error : LoginController.onError
		};
		$.ajax(values);
	},

	onSuccess : function(response) {
		// alert(JSON.stringify(response));
		// se login for autorizado
		if (response['error'] === "0") {
			LoginController.hash = response['hash'];
			// vai pra proxima pagina
			$.mobile.changePage("home.html", {
				allowSamePageTransition : true,
				showLoadMsg : true,
				reloadPage : true
			});
		} else {
			alert(response['errorMessage']);
		}

	},
	onError : function(e) {
		alert("Houve um erro na comunicação com servidor");
	},
	validate : function() {
		if (LoginController.login === "") {
			throw "E-mail e obrigatorio";
		}
		if (LoginController.password === "") {
			throw "Senha e obrigatorio";
		}
	},
	reset : function() {
		LoginController.login = "";
		LoginController.password = "";
		LoginController.hash = "";
		}
};

$(document).on("pagebeforecreate", "#login", function() {
	try {
		LoginController.init();
	} catch (err) {
		alert(err.message);
		window.location = "index.html";
	}
});

$(document).on("pageshow", "#login", function() {
	LoginController.reset();
});
