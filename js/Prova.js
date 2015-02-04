ProvaController = new Controller("prova", "linkProva", "", "attrid");

ProvaController.QuestaoSelecionadaIndex = 0;

ProvaController.setShowScreenList(function(items) {

	var html = "";
	for (t in items) {
		var link = HTMLMaker().createTag("a").attr("href", "iniciarprova.html")
				.attr("class", ProvaController.linkClass).attr(
						'data-transition', 'slide').attr("attrid", items[t].id)
				.content(items[t].titulo);

		var linkIcon = HTMLMaker().createTag("a").attr('data-transition',
				'slide').attr("href", "iniciarprova.html").attr("class",
				ProvaController.linkClass).attr("attrid", items[t].id).content(
				items[t].titulo);

		html += HTMLMaker().createTag("li").content(
				link.show() + linkIcon.show()).show();
	}

	$("#divListaProva").html(html);
	$('#divListaProva').listview('refresh');

});

ProvaController.setShowItem(function(item) {
	$('#tableDadosProva tbody  tr:last td:eq(0)').html(item.titulo);
	$('#tableDadosProva tbody tr:last td:eq(1)').html(item.autor);
	$('#tableDadosProva tbody tr:last td:eq(2)').html(item.data);
	$('#tableDadosProva tbody tr:last td:eq(3)').html(item.questoes.length);
	ProvaExecucaoController.provaSelecionada = item;
	$('#iniciarprova').trigger('create');
	$( "#tableDadosProva" ).table( "rebuild" );
});

$(document).on("pagebeforecreate", "#home", function() {
	try {
		if (LoginController.hash === "") {
			throw "Usuario deve estar logado";
		}
		ProvaController.init();
	} catch (err) {
		window.location = "index.html";
	}
});

$(document).on("pagebeforecreate", "#iniciarprova", function() {
	try {
		if (LoginController.hash === "") {
			throw Values.messageUsuarioDeveLogar;
		}

	} catch (err) {
		window.location = "index.html";
	}
});