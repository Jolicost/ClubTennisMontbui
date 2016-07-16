$(document).ready(function(){
	$(document).resize(setFooter);
	setFooter();
});


function setFooter(){
	var tot = $(document).outerHeight();
	var foo = $("#footer").outerHeight(true);
	$("#wrapper").css("min-height",tot - foo);
}