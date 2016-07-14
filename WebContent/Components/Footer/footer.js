$(document).ready(function(){
	/*$(document).resize(setFooter);
	setFooter();
	*/

});


function setFooter(){
	var tot = $(document).outerHeight();
	var wrap = $("#wrapper").outerHeight();
	var foo = $("#footer").outerHeight(true);
	
	if (foo + wrap < tot){
		$("#wrapper").height(tot - foo);
	}
	else $("#wrapper").height("auto");
}