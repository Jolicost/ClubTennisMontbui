$(document).ready(function() {
	$.getScript("Components/Util/getpost.js");
	var dia = $(".DiaSetmana");
	$(dia).each(function(index){
		var div = this;
		$(this).find(".HeaderDia").click(function(){
			$(div).toggleClass("actiu");
			var panel = $(div).find(".panel");
			$(panel).toggleClass("panel-default");
			$(panel).toggleClass("panel-success");
		});	
	});
	
	$("#acceptar").click(function(){
		SendData();
	})
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
	
	var dada = {
		inici:diaInici,
		fi:diaFi,
		dies:Dies,
	}
	
	post("submit",{info:JSON.stringify(dada)});
	
}

