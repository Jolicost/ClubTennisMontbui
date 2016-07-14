$(document).ready(function(){
	
	$('#seleccio').click( function(){

		post("select",{id:getSelectedKey()});
    });

});