$(document).ready(function() {
	$.getScript("Components/Util/getpost.js");
	
	$('.PanellDia').each(function(index){
		BindEvents(this);
	});
	
	$("#acceptar").click(function(){
		SendData();
	});
});


function SendData(){
	
	var Dies = [];
	$(".DiaSetmana.actiu").each(function(index){
		var numero = $(this).attr("dia");
		var dia = {
			diaSetmana:numero,
			inici:$(this).find("#inici_" + numero).val(),
			fi:$(this).find("#fi_" + numero).val(),
		}
		Dies.push(dia);
	});
	
	
	var diaInici = $(".IntervalDia #diainici").val();
	var diaFi = $(".IntervalDia #diafi").val();
	var t = $(".IntervalDia #tipus").val();
	
	var dada = {
		inici:diaInici,
		fi:diaFi,
		tipus:t,
		dies:Dies
	}
	
	post("submit",{info:JSON.stringify(dada)});
	
}

function BindEvents(panellDia){
	var div = $(panellDia).find(".DiaSetmana");
	$(div).find(".HeaderDia").click(function(){
		$(div).toggleClass("actiu");
		var panel = $(div).find(".panel");
		$(panel).toggleClass("panel-default");
		$(panel).toggleClass("panel-success");
	});
		
	$(div).find('.botonsDia .duplicar').click(function(){
		DuplicarDia($(this).closest('.PanellDia'));
	});
	
	$(div).find('.botonsDia .eliminar').click(function(){
		$(this).closest('.PanellDia').remove();
	});
	
}

function DuplicarDia(panellDia){
	var clone = $(panellDia).clone();
	clone.insertAfter(panellDia);
	BindEvents(clone);
}

