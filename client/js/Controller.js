/*Controller Base*/

/*Dependences: jQuery,Values*/

Controller = function(urlRequest,linkClass,param,attr) {
	
	var 
	items = [],
	item = null,
	urlFinal="",
	idSelected=0;
	
	var 
	urlRequest = urlRequest||"",
	param=param||"",
	linkClass=linkClass||"link",
	attr=attr||"id";
	
	function init(){
		getAll();
	
		$(document).off("click","."+linkClass).on("click","."+linkClass,
				clickItem);
	}

	function getAll() {
		urlFinal = urlRequest;
		doRequestGet(onSuccessGetAll, onError);
	}
	function getById(id) { 
	urlFinal = urlRequest+"/"+id;
		doRequestGet(onSuccessGetById, onError);
	}
	function reloadSelectedItem() { 
		
		showItem(item);	
	}
	function clickItem() {
		idSelected = $(this).attr(attr);
		getById(idSelected);
	}
	function onSuccessGetAll(response) {
		items = response.items;
		showScreenList(items);
	}
	function onSuccessGetById(response) {
		item = response.item;
		showItem(item);
	}

	function onError(response) {
		alert("fail");
	}

	function doRequestGet(onSuccess, onError) {
		var values = {
		beforeSend: function() { $.mobile.loading( 'show'); }, //Show spinner
	    complete: function() { $.mobile.loading( 'hide'); }, //Hide spinner
			type : "GET",
			dataType : "json",
			contentType : "application/json",
			url : Values.server  + urlFinal,
			data : JSON.stringify(param),
			success : onSuccess,
			error : onError
		};
		$.ajax(values);


	}
	function showScreenList(items) {
		alert(JSON.stringify(items));
	}
	function showItem(item) {
		alert(JSON.stringify(item));
	}
	
	function setShowScreenList(func){
		showScreenList = func;
	}
	function setShowItem(func) {
		showItem = func;
	}

	return {
		urlRequest:urlRequest,
		param:param,
		linkClass:linkClass,
		attr:attr,
		item:item,
		init : init,
		getAll:getAll,
		getById:getById,
		setShowItem:setShowItem,
		setShowScreenList:setShowScreenList,
		reloadSelectedItem:reloadSelectedItem
	};
};
