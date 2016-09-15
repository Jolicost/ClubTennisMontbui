<%@ page import="org.joda.time.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Communicacio.Dades.*" %>
<link rel='stylesheet' href='fullcalendar/fullcalendar.css' />
<script src='fullcalendar/lib/jquery.min.js'></script>
<script src='fullcalendar/lib/moment.min.js'></script>
<script src='fullcalendar/fullcalendar.js'></script>
<script src='fullcalendar/lang-all.js'></script>
<script src="Components/Calendari/Calendari.js"></script>
<script>
<% Set<InfoHorari> disponibilitats = (Set<InfoHorari>) (Set<?>) request.getAttribute("disponibilitats"); %>
$(document).ready(function() {
	$.getScript("Components/Util/getpost.js");
    // page is now ready, initialize the calendar...
	var evnts = LoadEvents();
    var pistes = LoadPistes();
    var mapa = SplitEvents(evnts,pistes);
    
    $('.VeurePista').click(function(){
    	AlternarPista($(this).attr("idpista"),mapa);
    	$(this).find('h3').toggleClass('text-info');
    });
    
    $('#calendar').fullCalendar({
    	lang:'ca',
    	header: {
    		left:   'title,myCustomButton',
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
        
    	/*
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
    	*/
    	
    	
        events: getVisibleEvents(mapa),
    })

});

function getVisibleEvents(mapa){
	var ret = [];
	for (var IDPista in mapa){
		var p = mapa[IDPista];
		if (p.visible){
			ret = ret.concat(p.values);
			
		}
		
		
		
	}
	console.log(ret);
	return ret;
}

function LoadEvents(){
	var events = [	
	<% 
	for (InfoHorari ih : disponibilitats){%>
		<%for (InfoLapse i: ih.getDisponibilitats()){%>
			{
				title: '<%= ih.getNomPista() %>',
	            start: '<%= i.getInterval().getStart().toString() %>',
	            end: '<%= i.getInterval().getEnd().toString() %>',
	            IDPista: <%= ih.getIDPista() %>,
			},
		<%}%>
	<%}%>
	];
	return events;	
}

function LoadPistes(){
	return [
	<% 
	for (InfoHorari ih : disponibilitats){%>
		<%= ih.getIDPista() %>,
	<%}%>
	];
}

function SplitEvents(events,idsPistes){
	var pistes = {};
	for (var i = 0; i < idsPistes.length; i ++){
		pistes[idsPistes[i]] = {
			values:[],
			visible:true,
				
		};
	}
	for (var i = 0; i < events.length; i ++){
		var pista = events[i].IDPista;
		pistes[pista].values.push(events[i]);
	}
	return pistes;
}

function AlternarPista(IDPista,mapa){
	mapa[IDPista].visible = !mapa[IDPista].visible;
	if (mapa[IDPista].visible){
		$('#calendar').fullCalendar('addEventSource',mapa[IDPista].values);
	}
	else{
		$('#calendar').fullCalendar('removeEvents',function(event){
			return event.IDPista == IDPista;
		});
	}
	/*$('#calendar').fullCalendar('removeEvents');
	$('#calendar').fullCalendar('addEventSource',getVisibleEvents(mapa));*/
 	$('#calendar').fullCalendar('rerenderEvents');
}

</script>
<% if (disponibilitats.size() > 1){ %>
<div class="container container-fluid">
<div class="panel-group" id="accordion">
	<br/>
	<div class="panel panel-default">
	    <div class="panel-heading">
	        <h4 class="panel-title">
	            <p class="accordion-toggle text text-center text-muted" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
	            <strong>Mostrar Pistes
	            </strong>
	            </p>
	            
	        </h4>
	    </div>
	    <div id="collapseOne" class="panel-collapse collapse" style="margin:20px">
	    	<div class="row">
	    	<div class="col col-md-6 col-md-offset-3">
	    	<% 
			for (InfoHorari ih : disponibilitats){%> 
				
				<div class="col col-md-4 VeurePista" idpista=<%= ih.getIDPista() %>>
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="text text-center text-muted text-info">
								<strong>
								<%= ih.getNomPista() %>
								</strong>
							</h3>
						</div>
					</div>
					
				</div>
			<%}%>
			</div>
			</div>
	    </div>
	</div>
</div>
</div>
<% } %>
<div id="calendar" class="container container-fluid">
</div>