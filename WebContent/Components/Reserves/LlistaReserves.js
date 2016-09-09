/**
 * 
 */

$(document).ready(function() {
	$.getScript("Components/Util/getpost.js");
	$('.cancelar-reserva').click(function(){
		if (confirm("Vols eliminar aquesta reserva?")){
			var franja = $(this).attr("franja");
			post('cancelarReserva',{idFranja:franja})
		}
	});
	

} );