<%@ page import="Communicacio.Dades.*" %>
<%@ page import="java.util.*" %>
<link rel='stylesheet' href='fullcalendar/fullcalendar.css' />
<script src='fullcalendar/lib/jquery.min.js'></script>
<script src='fullcalendar/lib/moment.min.js'></script>
<script src='fullcalendar/fullcalendar.js'></script>
<script src='fullcalendar/lang-all.js'></script>
<div class="container">
	<% 
		Set<InfoFranjaSetmanal> info = (Set<InfoFranjaSetmanal>)(Set<?>) request.getAttribute("taula");
	%>
	<script>
		function handleResponse(data,status){
			if (status == 'success'){
				var node = JSON.parse(data);
				var taula = node.taula;
				var events = createEvents(taula);
				console.log(events);
				$('#calendar').fullCalendar('removeEvents');
				$('#calendar').fullCalendar('addEventSource',events);
				$('#calendar').fullCalendar('rerenderEvents');
			}
			else{
				alert(data);
			}
		}
		function insertFranja(franja){
			var Jfranja = JSON.stringify(franja);
			var url = '/insertarFranja';
			$.post(url,{info:Jfranja},function(data,status){
				handleResponse(data,status);
				checkDisplay();
			});
		}
		function deleteFranges(){
			var ids = getSelectedIds();
			var Jdata = JSON.stringify(ids);
			var url = '/eliminarFranges';
			$.post(url,{info:Jdata},function(data,status){
				handleResponse(data,status);
				checkDisplay();
			});
		}
		function getSelectedIds(){
			var franges = getSelectedEvents();
			var ret = new Array();
			for (var i = 0; i < franges.length; i++){
				ret.push(franges[i].id);
			}
			return ret;
		}
		function updateFranja(franja){
			var url = '/updateFranja';
			var Jfranja = JSON.stringify(franja);
			$.post(url,{info:Jfranja},function(data,status){
				handleResponse(data,status);
				checkDisplay();
			});
		}
		function getFranjaData(){
			var form = $('div#editor');
	    	var Vinici = $(form).find('input#inici').val();
	    	var Vfi = $(form).find('input#fi').val();
	    	var Vdia = $(form).find('#diaSetmana').prop('selectedIndex');
	    	
			var ret = {
				inici:Vinici,
				fi:Vfi,
				diaSetmana:Vdia
			};
			
			try{
				ret.id = getSelectedEventID();
			}
	    	catch (e){
	    		//nothin buddy
	    	}
	    	
	    	return ret;
	    	
		}
		function handleSubmit(){
			
			var form = $('div#editor');
	    	var method = $(form).find('#submit').attr('method');
	    	if (method == 'update'){
	    		updateFranja(getFranjaData());	
	    	}
	    	else if (method == 'insert'){
	    		insertFranja(getFranjaData());	
	    	}		
		}


		function getFranges(){
			var franges = [
				<% 
			
					for (InfoFranjaSetmanal i: info){
						out.print(i.toJSon());
						out.print(",");
					}	
				%>
			];
			return franges;
		}
	
		
		function getStartofWeekDate(){
			return moment().startOf('isoweek');
		}
		
		function composeFranjaDate(franja){
			var data = getStartofWeekDate();
			data.add(franja['diaSetmana'],'days');
	
			var inici = moment(data);
			var fi = moment(data);
			
			var Dinici = moment.duration(franja['inici']);
			var Dfi = moment.duration(franja['fi']);
			
			inici = inici.add(Dinici);
			fi = fi.add(Dfi);
			
			return {
				start:inici.toDate(),
				end:fi.toDate()
			};
		}
		function getDayWeekIndex(date){
			var ret = moment(date);
			return ret.isoWeekday() - 1;
		}
		function getEventColor(selected){
			
			if (selected) return 'green';
			else return 'default';
		}
		function getSelectedEvent(){
			var events = $(calendar).fullCalendar('clientEvents');
			for (var i = 0; i < events.length; i++){
				if (events[i].selected) return events[i];
			}
			throw "event does not exist";
		}
		function getSelectedEvents(){
			var ret = new Array();
			var events = $(calendar).fullCalendar('clientEvents');
			for (var i = 0; i < events.length; i++){
				if (events[i].selected) ret.push(events[i]);
			}
			return ret;
		}
		function getSelectedEventID(){
			return getSelectedEvent().id;
		}
		function checkDisplay(){
			try{
				var event = getSelectedEvent();
				displayUpdate(event);
			}
			catch(noSelected){
				displayInsert();
			}
		}
		function displayUpdate(calEvent){
			var form = $('div#editor');
			var inici = moment(calEvent.start);
			var fi = moment(calEvent.end);
			
	    	$(form).find('input#inici').val(inici.format('HH:mm'));
	    	$(form).find('input#fi').val(fi.format('HH:mm'));
	    	$(form).find('#diaSetmana').prop('selectedIndex',getDayWeekIndex(calEvent.start));
	    	
	    	$(form).find('#submit').attr('method','update');
	    	$(form).find('#submit').html('Editar');
		}
		function displayInsert(){
			var form = $('div#editor');
			
	    	$(form).find('#inici').val("");
	    	$(form).find('#fi').val("");
	    	$(form).find('#diaSetmana').prop('selectedIndex',"");
	    	
	    	
	    	$(form).find('#submit').attr('method','insert');
	    	$(form).find('#submit').html('Insertar');
		}
		function Select(calEvent){
			calEvent.selected = !calEvent.selected;
			calEvent.color = getEventColor(calEvent.selected);
			
			checkDisplay();
		}

		function createEvents(franges){
			var ret = [];
			for (var i = 0; i < franges.length; i++){
				var interval = composeFranjaDate(franges[i]);
				ret.push({
					start: interval.start,
					end: interval.end,
					id: franges[i]['id'],
					selected: false
				});
			}
			return ret;
		}

		$(document).ready(function() {
			$.getScript("Components/Util/getpost.js");
		    // page is now ready, initialize the calendar...
			var franges = getFranges();
		    
		    
		    
		    $('#calendar').fullCalendar({
		    	lang:'ca',
		    	header: {
		            right:  'agendaWeek,agendaDay'
		    	},
		    	height:'auto',
		    	firstDay:1,
		    	businessHours:true,
		    	
		    	defaultView: 'agendaWeek',
		    	
		    	views:{
		        	agendaWeek:{
		        		minTime:'08:00',
		        		allDaySlot:false
		        	},
		        	agendaDay:{
		        		minTime:'08:00',
		        		slotEventOverlap:false,
		        		allDaySlot:false
		        	}
		        	
		    	},
		    	
		    	eventClick: function(calEvent, jsEvent, view) {
					Select(calEvent);
					$('#calendar').fullCalendar('rerenderEvents');
		        },
		    	
		        events: createEvents(franges)
		    });

		    $('button#submit').click(function(){
		    	handleSubmit();
		    });
		    $('button#delete').click(function(){
		    	deleteFranges();
		    });
		    $('button#duplicate').click(function(){
		    	handleDuplicate();
		    });
		});
	</script>
<div class="row">
	<div class="col col-sm-8">
		<div id="calendar"></div>
	</div>
	<div class="col col-sm-4">
		<div class="panel panel-default">
			<div class="panel-body" id="editor">
				<div class="form-group">
			  		<label for="inici">Inici:</label>
			  		<input type="time" name="inici" class="form-control" id="inici">
				</div>
				<div class="form-group">
			  		<label for="fi">Fi:</label>
			  		<input type="time" name="fi" class="form-control" id="fi">
				</div>
				<div class="form-group">
			      <label for="diaSetmana">Dia Setmana:</label>
			      <select class="form-control" id="diaSetmana">
			        <option>Dilluns</option>
			        <option>Dimarts</option>
			        <option>Dimecres</option>
			        <option>Dijous</option>
			        <option>Divendres</option>
			        <option>Dissabte</option>
			        <option>Diumenge</option>
			      </select>
				</div>
				<div class="form-group">
					<button class="btn btn-default" id="submit" method="insert">Insertar</button>
					<button class="btn btn-default" id="delete">Eliminar</button>
					<button class="btn btn-default" id="duplicate">Duplicar</button>
				</div>
				
			</div>
		</div>
	</div>
</div>

</div>