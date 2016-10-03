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
$(document).ready(function() {
	$.getScript("Components/Util/getpost.js");
    // page is now ready, initialize the calendar...

    var evnts = LoadEvents();
    var pistes = LoadPistes();
    var mapa = SplitEvents(evnts,pistes);
    
    $('.VeurePista').click(function(){
    	AlternarPista($(this).attr("idpista"),mapa);
    });
    
    $('.VeurePista').dblclick(function(){
    	HabilitarUnica($(this).attr("idpista"),mapa,pistes);
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
        
    	
        events: getVisibleEvents(mapa),
    	
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
	for (InfoHorari ih : ocupacions){%>
		<%for (InfoLapse i: ih.getDisponibilitats()){%>
			<% InfoFranja f = i.toInfoFranja();%>
			{
				title: '<%= ih.getNomPista() + "," + f.getTitol() %>',
	            start: '<%= i.getInterval().getStart().toString() %>',
	            end: '<%= i.getInterval().getEnd().toString() %>',
	            IDPista: <%= ih.getIDPista() %>,
	            franja: '<%= f.getIdFranja() %>',
	            sel:false,
	            colorSec:'green',
			},
		<%}%>
	<%}%>
	];
	return events;	
}

function LoadPistes(){
	return [
	<% 
	for (InfoHorari ih : ocupacions){%>
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

function DeshabilitarPista(IDPista,mapa){
	if (mapa[IDPista].visible) AlternarPista(IDPista,mapa);
}

function HabilitarPista(IDPista,mapa){
	if (!mapa[IDPista].visible) AlternarPista(IDPista,mapa);	
}

function HabilitarUnica(IDPista,mapa,idsPistes){
	for (var i = 0; i < idsPistes.length ; i++){
		var id = idsPistes[i];
		if (id != IDPista) DeshabilitarPista(id,mapa);
	}
	
	HabilitarPista(IDPista,mapa);
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
 	$('#calendar').fullCalendar('rerenderEvents');
 	$('.VeurePista').each(function(index){
 		if ($(this).attr("idpista") == IDPista){
 			$(this).find('h3').toggleClass('text-info');
 		}
 	});
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
</div>
</div>
<% } %>

<div id="botons" class="container contaner-fluid">
<button id="update" type="button" class="btn btn-default">Editar</button>
<!-- <button id="insert" type="button" class="btn btn-default">Insertar</button> -->
<button id="delete" type="button" class="btn btn-default">Eliminar</button>
</div>
<div id="calendar" class="container container-fluid">
</div>