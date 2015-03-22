/**
 * Object with values that is used for all aplication
 * 
 * Dependences: Jquery, JqueryMobile
 */
App = {
		
	init : function() {
			  Values.init();
			  Snippets.init();
	}
};

$(document).on("pagebeforecreate",function(event){
	App.init();
});