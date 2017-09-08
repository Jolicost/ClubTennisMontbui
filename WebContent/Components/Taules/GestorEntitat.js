$(document).ready(function() {
	 
	$.getScript("Components/Util/getpost.js");
	 $('#editar').click( function(){

			post("editar",{id:getSelectedKey()});
	    });

		$('#insertar').click(function(){
			get("insertar");
		});
		
		$('#eliminar').click( function(){
			if (confirm("Vols eliminar: " + getSelectedKey() + "?")){
				post("eliminar",{id:getSelectedKey()});
			};		
	    });
		
		$('#seleccio').click( function(){

			post("select",{id:getSelectedKey()});
	    });   
	    
		$('#editarfranges').click(function(){
			post("editarFranges",{id:getSelectedKey()});
		});
	 
	 $('#example tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
	            $(this).removeClass('selected');
	        }
	        else {
	            table.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	        }
	} );   
	
	var table = null;
	var domtable = $('#example');
	if ($(domtable).length > 0){table = $(domtable).DataTable();}
	
	function getSelectedKey(){
    	return table.rows('.selected').data()[0][getKeyIndex()];
    }
    
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
    
    
    
    
    

	
	
    
	  
    
} );