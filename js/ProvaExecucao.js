ProvaExecucaoController = function() {
	var provaSelecionada = null;
	var questaoSelecionadaIndex = 0;

	function getQuestaoAtual() {
		return ProvaExecucaoController.provaSelecionada.questoes[questaoSelecionadaIndex];
	}

	function getQuestaoCount() {
		return ProvaExecucaoController.provaSelecionada.questoes.length;
	}
	function getRespostas() {
		var questoes = ProvaExecucaoController.provaSelecionada.questoes;

		var retorno = {
			provaId : ProvaExecucaoController.provaSelecionada.id,
			respostas : []
		};
		for (var i = 0; i < getQuestaoCount(); i++) {
			if (questoes[i].resposta)
				retorno.respostas.push(questoes[i].resposta||"");
		}
		return retorno;

	}
	function init() {

		$("#btnNext").click(function() {
			atualizaRespostaQuestaoAtual();
			proximaIndice();
			recarregarPagina();
		});

		$("#btnAnt").click(function() {
			atualizaRespostaQuestaoAtual();
			anteriorIndice();
			recarregarPagina();
		});
		$("#btnConfirmFinalizar").click(function() {
			atualizaRespostaQuestaoAtual();
		});

		carregaQuestaoTela();
	}
	function recarregarPagina() {

		$.mobile.changePage(window.location.href, {
			allowSamePageTransition : true,
			transition : 'slide',
			showLoadMsg : false,
			reloadPage : false
		});
		carregaQuestaoTela();
	}

	function atualizaRespostaQuestaoAtual() {

		var questao = getQuestaoAtual();

		switch (questao.tipo) {
		case 0: // aberto
			var text = $("#fieldtextRespostaAberta").val();
			questao.resposta = text;
			break;
		case 1: // fechada
			questao.resposta = $("input[type='radio']:checked").val();
			break;
		}

	}

	function carregaQuestaoTela() {
		var questao = getQuestaoAtual();

		var contador = HTMLMaker().createTag("h4").content(
				"(" + (questaoSelecionadaIndex + 1) + " de "
						+ getQuestaoCount() + ")");
		$('#questaoEnunciado').html(questao.enunciado + "" + contador.show());

		$(".divResposta").each(function() {
			$(this).hide();
		});

		switch (questao.tipo) {
		case 0: // aberto
			// mostra aberta
			$("#fieldtextRespostaAberta").val(questao.resposta || "");
			$("#fieldRespostaAberta").show();
			break;

		case 1: // fechada
			$("#fieldRespostaFechada").html("");
			var snippetItem = Snippets
					.getSnippet('snippet-item-resposta-fechada');
			var snippetItemLabel = Snippets
					.getSnippet('snippet-item-resposta-fechada-label');
			var html = "";
			for (var t = 0; t < questao.alternativas.length; t++) {
				html += snippetItem.updateAttr("id", t).updateAttr("value", t)
						.show();
				html += snippetItemLabel.updateAttr("for", t).content(
						questao.alternativas[t]).show();
			}
			$("#fieldRespostaFechada").html(html);
			$("input[type='radio']").checkboxradio();
			$("input[type='radio']").checkboxradio("refresh");

			if (questao.resposta != undefined) {
				$("input[type='radio']:eq(" + questao.resposta + ")").attr(
						"checked", "checked");
				$("input[type='radio']").checkboxradio("refresh");
			}

			// mostra fechada
			$("#fieldRespostaFechada").show();
			break;
		}
	}

	function proximaIndice() {
		var novoIndice = questaoSelecionadaIndex;
		novoIndice++;
		if (novoIndice < getQuestaoCount()) {
			questaoSelecionadaIndex = novoIndice;
		} else {
			questaoSelecionadaIndex = 0;
		}
	}

	function anteriorIndice() {
		var novoIndice = questaoSelecionadaIndex;
		novoIndice--;
		if (novoIndice >= 0) {

			questaoSelecionadaIndex = novoIndice;
		} else {
			questaoSelecionadaIndex = getQuestaoCount() - 1;
		}
	}
	return {
		init : init,
		provaSelecionada : provaSelecionada,
		getQuestaoAtual : getQuestaoAtual,
		anteriorIndice : anteriorIndice,
		proximaIndice : proximaIndice,
		questaoSelecionadaIndex : questaoSelecionadaIndex,
		getRespostas : getRespostas
	};
}();

$(document).on("pagebeforecreate", "#responder", function() {
	try {
		ProvaExecucaoController.init();
	} catch (err) {
		alert("Houve um erro inesperado");
		window.location = "index.html";
	}
});
