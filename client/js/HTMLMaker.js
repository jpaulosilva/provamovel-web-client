
HTMLMaker = function() {
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
};