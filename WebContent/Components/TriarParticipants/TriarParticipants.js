/**
 * 
 */

$(document).ready(function(){

	$.getScript("Components/Util/getpost.js");

	var table = null;
	var domtable = $('#socis');
	if ($(domtable).length > 0){table = $(domtable).DataTable();}	

	checkSeleccionar();
	
	$('#socis tbody').on( 'click', 'tr', function () {
		var can = true;
		if (!$(this).hasClass('selected')){
			can = canSelect();
		}
		if (can) $(this).toggleClass('selected');
		checkSeleccionar();
	}); 

	$('#seleccionar').click(function(){
		var json = JSON.stringify({
				socis:getSelectedKeys()
		});
		
		post('TriarParticipants',{info:json});
	});

	function getSelectedKeys(){
		var ret = new Array();
		for (var i = 0; i < table.rows('.selected').data().length; i++){
			var row = table.rows('.selected').data()[i];
			ret.push(row[getKeyIndex()]);
		}
		return ret;
	}

	function getKeyIndex(){
		return 0;
	}
	
	function canSelect(){
		return getNSelectedRows() < getMaxPlayers();
	}
	
	function getNSelectedRows(){
		return $('#socis tbody .selected').size();
	}
	
	function getMinPlayers(){
		return min-1;
	}
	function getMaxPlayers(){
		return max-1;
	}
	function checkSeleccionar(){
		$('#seleccionar').prop('disabled',function(i,v){
			return !(getMinPlayers() <= getNSelectedRows() && getNSelectedRows() <= getMaxPlayers());
		});
	}
});