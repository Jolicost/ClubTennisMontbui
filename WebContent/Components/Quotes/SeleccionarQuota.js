$(document).ready(function(){
	$.getScript("Components/Util/getpost.js");
	$("button").click(function(){
		var t = $(this).attr('id');
		get("SeleccionarQuota",{tipus:t});
	});
});
