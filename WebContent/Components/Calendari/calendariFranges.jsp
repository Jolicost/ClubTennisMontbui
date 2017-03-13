<%@ page import="org.joda.time.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Communicacio.Dades.*" %>
<%@ page import="Communicacio.Dades.Reserves.*" %>
<link rel='stylesheet' href='fullcalendar/fullcalendar.css' />
<script src='fullcalendar/lib/jquery.min.js'></script>
<script src='fullcalendar/lib/moment.min.js'></script>
<script src='fullcalendar/fullcalendar.js'></script>
<script src='fullcalendar/lang-all.js'></script>
<script>
<% Set<InfoHorari> ocupacions = (Set<InfoHorari>) (Set<?>) request.getAttribute("taula"); %>
<%
Set<String> nomsTipus = new HashSet<>();
for (InfoHorari ih:ocupacions){
	for (InfoLapse il: ih.getDisponibilitats()){
		nomsTipus.add(il.getTipus());
	}
}

%>
$(document).ready(function() {
	$.getScript("Components/Util/getpost.js");
    // page is now ready, initialize the calendar...

    var evnts = LoadEvents();
    var pistes = LoadPistes();
    var tipus = LoadTipus();
    
    var mapaPistes = Split(evnts,pistes,consultEventPista);
    var mapaTipus = Split(evnts,tipus,consultEventTipus);
    
    
    $('.VeurePista').click(function(){
    	var idPista = $(this).attr("idpista");
    	AlternarEvent(idPista,mapaPistes,consultEventPista);
    	rerenderEvents(evnts,mapaPistes,mapaTipus);
     	$(this).find('h3').toggleClass('text-info');
    });
    
    
    $('.VeureTipus').click(function(){
    	AlternarEvent($(this).attr("nomTipus"),mapaTipus,consultEventTipus);
    	rerenderEvents(evnts,mapaPistes,mapaTipus);
    	$(this).find('h3').toggleClass('text-info');
    });
     
    
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
        
    	
        events: evnts,
    	
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
    
    $('#detalls').click(function(){
    	var events = $('#calendar').fullCalendar('clientEvents',isSelected);
    	if (events.length > 0) mostrarDetalls(events[0]);
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

function LoadEvents(){
	var events = [	
	<% 
	for (InfoHorari ih : ocupacions){%>
		<%for (InfoLapse i: ih.getDisponibilitats()){%>
			<% InfoFranja f = i.toInfoFranja();%>
			{
				title: '<%= ih.getNomPista() + "," + f.getTitol() %>',
	            start: '<%= i.getInterval().getStart().toString() %>',
	            end: '<%= i.getInterval().getEnd().toString() %>',
	            IDPista: <%= ih.getIDPista() %>,
	            franja: '<%= f.getIdFranja() %>',
	            nomTipus: '<%= f.getTipus() %>',
	            detalls:{
	            	participants:'<%= f.printParticipants()%>'
	            },
	            sel:false,
	            colorSec:'green',
			},
		<%}%>
	<%}%>
	];
	return events;	
}

function mostrarDetalls(franja){
	var detalls = franja.detalls;
	var msg = "";
	for (var prop in detalls){
		msg += prop  + ': ' + detalls[prop];
	}
	alert(msg);
}


function Split(events,values,fConsultEvent){
	var ret = {};
	for (var i = 0; i < values.length; i++){
		ret[values[i]] = {
			values:[],
			visible:true,
		};
	}
	for (var i = 0; i < events.length; i ++){
		var value = fConsultEvent(events[i]);
		ret[value].values.push(events[i]);
	}
	return ret;
}

function Deshabilitar(key,map,fConsultEvent){
	if (map[key].visible) AlternarEvent(key,map,fConsultEvent);
}

function Habilitar(key,map,fConsultEvent){
	if (!map[key].visible) AlternarEvent(key,map,fConsultEvent);
}

function HabilitarUnique(key,map,fConsultEvent){
	for (var i = 0; i < idsPistes.length ; i++){
		var id = idsPistes[i];
		if (id != IDPista) Deshabilitar(id,map,fConsultEvent);
	}
	
	Habilitar(key,map,fConsultEvent);
}

function consultEventPista(event){
	return event.IDPista;
}
function consultEventTipus(event){
	return event.nomTipus;
}

function AlternarEvent(key,map){
	map[key].visible = !map[key].visible;
}

function LoadPistes(){
	return [
	<% 
	for (InfoHorari ih : ocupacions){%>
		<%= ih.getIDPista() %>,
	<%}%>
	];
}


function LoadTipus(){
	return [
	<% 
	for (String s : nomsTipus){%>
		<%="'" + s + "'"%>,
	<%}%>
	];
}

function rerenderEvents(evnts,mapaPistes,mapaTipus){
	$('#calendar').fullCalendar('removeEvents');
	var toAdd = [];
	for (var i = 0; i < evnts.length ; i++){
		var event = evnts[i];
		if (mapaPistes[event.IDPista].visible && mapaTipus[event.nomTipus].visible){
			toAdd.push(event);
		}
	}
	console.log(toAdd);
	$('#calendar').fullCalendar('addEventSource',toAdd);
	$('#calendar').fullCalendar('rerenderEvents');
}

</script>
<% if (ocupacions.size() > 1){ %>
<div class="container container-fluid">
<div class="panel-group" id="accordion">
	<br/>
	<div class="panel panel-default">
	    <div class="panel-heading">
	        <h4 class="panel-title">
	            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
	            <p class="text text-center text-muted"><strong>Mostrar Pistes
	            </strong>
	            </p>
	            </a>
	            
	        </h4>
	    </div>
	    <div id="collapseOne" class="panel-collapse collapse">
	    	<div class="row" style="margin:10px">
	    	<div class="col col-md-6 col-md-offset-3">
	    	<% 
			for (InfoHorari ih : ocupacions){%> 
				
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
	<br>
	<div class="panel panel-default">
	    <div class="panel-heading">
	        <h4 class="panel-title">
	            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
	            <p class="text text-center text-muted"><strong>Mostrar Tipus
	            </strong>
	            </p>
	            </a>
	            
	        </h4>
	    </div>
	    <div id="collapseTwo" class="panel-collapse collapse">
	    	<div class="row" style="margin:10px">
	    	<div class="col col-md-6 col-md-offset-3">
	    	<% 
			for (String s: nomsTipus){%> 
				
				<div class="col col-md-4 VeureTipus" nomTipus='<%=s%>'>
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="text text-center text-muted text-info">
								<strong>
								<%=s%>
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

<div id="botons" class="container contaner-fluid">
<button id="update" type="button" class="btn btn-default">Editar</button>
<!-- <button id="insert" type="button" class="btn btn-default">Insertar</button> -->
<button id="delete" type="button" class="btn btn-default">Eliminar</button>
<button id="detalls" type="button" class="btn btn-default">Detalls</button>
</div>
<div id="calendar" class="container container-fluid">
</div>