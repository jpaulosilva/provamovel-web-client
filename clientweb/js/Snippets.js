/**
 * @author Ivan Rodrigues
 * @version 1.0.0 Dependences: jquery
 */

var Snippets = {

	init : function() {
		$(".html-from-snippets").each(function() {
			var snippet = $(this).attr('snippet')
			var html = $("#" + snippet).html();
			$(this).html(html);
		});
		$(".html-from-snippet-array").each(function() {

			var snippet = $(this).attr('snippet');
			var html = Snippets.getSnippet(snippet);
			$(this).html(html.show());
		});
	},
	snippetValues : [
			{
				id : 'snippet-btn-home',
				value : HTMLMaker()
						.createTag("a")
						.attr("href", "index.html")
						.attr("data-role='button'")
						.attr("class",
								"ui-btn ui-btn-right ui-icon-home ui-btn-icon-left")
						.content("Home")
			},
			{
				id : 'snippet-footer',
				value : HTMLMaker().createTag("a").attr("href", "about.html")
						.attr("data-transition", "slideup").attr("class",
								"ui-btn ui-corner-all").attr("style",
								"width: 100%").content(Values.appFooterAbout)
			},
			{
				id : 'snippet-footer-questpes',
				value : HTMLMaker().createTag("a")
						.attr("href", "questoes.html").attr("data-transition",
								"slideup")
						.attr("class", "ui-btn ui-corner-all").attr("style",
								"width: 100%").content("Quest�es")
			},
			{
				id : 'snippet-btn-voltar',
				value : HTMLMaker()
						.createTag("a")
						.attr("href", "#")
						.attr("data-transition", "slide")
						.attr("data-rel", "back")
						.attr("class",
								"ui-btn ui-btn-left ui-icon-back ui-btn-icon-left")
						.content("Voltar")
			},
			{
				id : 'snippet-btn-sair',
				value : HTMLMaker()
						.createTag("a")
						.attr("href", "index.html")
						.attr("data-transition", "slide")
						.attr("class",
								"ui-btn ui-btn-left ui-icon-delete ui-btn-icon-left")
						.content("Sair")
			},
			{
				id : 'snippet-item-resposta-fechada',
				value : HTMLMaker().createTag("input").attr("type", "radio")
						.attr("name", "respostaFechada").content("")
			}, {
				id : 'snippet-item-resposta-fechada-label',
				value : HTMLMaker().createTag("label").content("")
			}

	],
	getSnippet : function(id) {
		for (var i = 0; i < Snippets.snippetValues.length; i++) {
			if (id === Snippets.snippetValues[i].id) {
				return Snippets.snippetValues[i].value;
			}
		}
		throw "Snippet ID is not found";
		return null;
	},
	HTMLMaker : function() {
		var tagVar = {
			tagName : "",
			attr : [],
			content : ""
		};
		function createTag(tagName) {
			tagVar.tagName = tagName;
			tagVar.attr = [];
			return this;
		}
		function attr(attribute, value) {
			tagVar.attr.push({
				key : attribute,
				value : value
			});
			return this;
		}
		function updateAttr(attribute, value) {

			for (var t=0;t<tagVar.attr.length;t++) {
				if(tagVar.attr[t].key === attribute){

					tagVar.attr[t].value = value;
					return this;
				}
			}

			return this.attr(attribute, value);
			
		}
		function resetAttr(attribute, value) {
			tagVar.attr = [];
			return this;
		}
		function content(value) {
			if (typeof (value) === "object") {
				tagVar.content = value.show();
			} else {
				tagVar.content = value;
			}
			return this;
		}
		function show() {
			var htmlReturn = "<" + tagVar.tagName + " ";
			for ( var c in tagVar.attr) {
				htmlReturn += " " + tagVar.attr[c].key + "='"
						+ tagVar.attr[c].value + "' ";
			}
			htmlReturn += ">" + tagVar.content + "</" + tagVar.tagName + ">";
			return htmlReturn;
		}
		
		function clone() {
		    if (null == this || "object" != typeof obj) return obj;
		    var copy = this.constructor();
		    for (var attr in this) {
		        if (this.hasOwnProperty(attr)) copy[attr] = this[attr];
		    }
		    return copy;
		}

		return {
			createTag : createTag,
			attr : attr,
			content : content,
			show : show,
			updateAttr:updateAttr,
			clone:clone
		};
	}
};
