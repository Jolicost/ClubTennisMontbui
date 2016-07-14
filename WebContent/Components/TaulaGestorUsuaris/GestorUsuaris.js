$(document).ready(function() {
	 var table = $('#example').DataTable();
	    
	    
	 $('#example tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
	            $(this).removeClass('selected');
	        }
	        else {
	            table.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	        }
	} );   
	$('#editar').click( function(){

		post("editar",{id:getSelectedKey()});
    });
	//
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
	$('assignar').click(function(){
		get("assignar",{entitat:"soci",id:getSelectedKey()});
	});
	
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
    
    function post(path, parameters) {
        var form = $('<form></form>');

        form.attr("method", "post");
        form.attr("action", path);

        $.each(parameters, function(key, value) {
            var field = $('<input></input>');

            field.attr("type", "hidden");
            field.attr("name", key);
            field.attr("value", value);

            form.append(field);
        });

        // The form needs to be a part of the document in
        // order for us to be able to submit it.
        $(document.body).append(form);
        form.submit();
    }
    
    function get(path, parameters) {
        var form = $('<form></form>');

        form.attr("method", "get");
        form.attr("action", path);

        $.each(parameters, function(key, value) {
            var field = $('<input></input>');

            field.attr("type", "hidden");
            field.attr("name", key);
            field.attr("value", value);

            form.append(field);
        });

        // The form needs to be a part of the document in
        // order for us to be able to submit it.
        $(document.body).append(form);
        form.submit();
    }
    

	
	
    
	  
    
} );