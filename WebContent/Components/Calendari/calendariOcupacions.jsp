<%@ page import="org.joda.time.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Communicacio.Dades.Info" %>
<%@ page import="Communicacio.Dades.Reserves.*" %>
<link rel='stylesheet' href='fullcalendar/fullcalendar.css' />
<script src='fullcalendar/lib/jquery.min.js'></script>
<script src='fullcalendar/lib/moment.min.js'></script>
<script src='fullcalendar/fullcalendar.js'></script>
<script src='fullcalendar/lang-all.js'></script>
<script>
<% Set<Info> ocupacions = (Set<Info>) (Set<?>) request.getAttribute("taula"); %>
$(document).ready(function() {
	$.getScript("Components/Util/getpost.js");
    // page is now ready, initialize the calendar...

    $('#calendar').fullCalendar({
    	lang:'ca',
    	header: {
    		left:   'title',
            center: 'today',
            right:  'month,agendaWeek,agendaDay, ,prev,next'
    	},
    	
    	height:'auto',
    
    	firstDay:1,
    	businessHours:true,
    	
    	
    	views:{
    		agendaDay:{
        		allDaySlot:false,
        		//minTime:'08:00',
        		slotEventOverlap:false
        	},
        	
        	agendaWeek:{
        		//minTime:'08:00',
        		allDaySlot:false
        	},
        	
    	},
    	
    	dayClick: function(date, jsEvent, view) {

    		/*if (view.name != 'agendaDay'){
    			$('#calendar').fullCalendar('changeView', 'agendaDay');
    		    $('#calendar').fullCalendar('gotoDate', date); 
    		}*/
           

        },
        
        eventClick: function(calEvent, jsEvent, view) {
			Select(calEvent);
			$('#calendar').fullCalendar('rerenderEvents');
        },
        
    	
        events: [
        	 <% for (Info i : ocupacions){
    				InfoFranja io = i.toInfoFranja();
        	 %>	
    		    	 {
    		    		 title: '<%= io.getTitol()%>',
    		             start: '<%= io.getInterval().getStart().toString() %>',
    		             end: '<%= io.getInterval().getEnd().toString() %>',
    		             franja: '<%= io.getIdFranja() %>',
    		             sel:false,
    		             colorSec:'green',
    		         },
        		 
        	 <%}%>
        ],
    	
    })
    
    

    $('#update').click(function(){
    	var array = $('#calendar').fullCalendar('clientEvents',isSelected);
    	if (array.length > 0){
    		get('editar',{id:array[0].franja});
    	}
    });
    
    $('#insert').click(function(){
    	get('insertar',{});
    });
    
    $('#delete').click(function(){
    	
    	var array = $('#calendar').fullCalendar('clientEvents',isSelected);
    	if (array.length == 1){
    		if (confirm("vols eliminar la franja: " + array[0].title + "?"))
    			get('eliminar',{id:array[0].franja});
    	}
    	else if (array.length > 1){
    		if (confirm("vols eliminar les franges seleccionades?")){
    			var franges = [];
    			for (var j = 0; j < array.length ; j++){
    				franges.push(array[j].franja);
    			}
    			var json = {set:franges};
    			get('eliminarSet',{ids:JSON.stringify(franges)});    
    		}
    					
    	}
    });

});

function Select(calEvent){
	calEvent.sel = !calEvent.sel;
	
	var antic = calEvent.color;
	calEvent.color = calEvent.colorSec;
	calEvent.colorSec = antic;
}

function isSelected(event){
	return event.sel;
}


</script>
<div id="botons" class="container contaner-fluid">
<button id="update" type="button" class="btn btn-default">Editar</button>
<button id="insert" type="button" class="btn btn-default">Insertar</button>
<button id="delete" type="button" class="btn btn-default">Eliminar</button>
</div>
<div id="calendar" class="container container-fluid">
</div>