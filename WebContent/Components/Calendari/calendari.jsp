<%@ page import="org.joda.time.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Communicacio.Dades.*" %>
<link rel='stylesheet' href='fullcalendar/fullcalendar.css' />
<script src='fullcalendar/lib/jquery.min.js'></script>
<script src='fullcalendar/lib/moment.min.js'></script>
<script src='fullcalendar/fullcalendar.js'></script>
<script src='fullcalendar/lang-all.js'></script>
<script>
<% Set<InfoHorari> disponibilitats = (Set<InfoHorari>) (Set<?>) request.getAttribute("disponibilitats"); %>
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
        		minTime:'08:00',
        		slotEventOverlap:false
        	},
        	
        	agendaWeek:{
        		minTime:'08:00',
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

        	var parameters = {
        		IDPista:calEvent.IDPista,
        		inici:calEvent.start,
        		fi:calEvent.end
        	};
        	
        	var s = JSON.stringify(parameters);
            post("SeleccionarFranja",{franja:s});

        },
        
    	
    	events: [
    	 <% for (InfoHorari ih : disponibilitats){%>
    	 	<%for (InfoLapse i: ih.getDisponibilitats()){%>
    	 	
		    	 {
		             title: '<%= ih.getNomPista() %>',
		             start: '<%= i.getInterval().getStart().toString() %>',
		             end: '<%= i.getInterval().getEnd().toString() %>',
		             IDPista: <%= ih.getIDPista() %>,
		         },
    		 
    	 	<%}%>
    	 <%}%>
    	],
    	
    })

});
</script>
<div id="calendar" class="container container-fluid">
</div>