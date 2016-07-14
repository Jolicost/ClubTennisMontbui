<%@ page import="java.util.Set" %>
<div class="IntervalDia">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="text-center text-muted">Interval</h3>
		</div>
		<div class="panel-body">
		<div class="form-group">
	  		<label for="diainici">Dia Inicial:</label>
	  		<input type="date" name="inici" class="form-control" id="diainici">
		</div>
		<div class="form-group">
	  		<label for="diafi">Dia Final:</label>
	  		<input type="date" name="fi" class="form-control" id="diafi">
		</div>
		<div class="form-group">
  			<label for="tipus">Tipus: </label>
			<select class="form-control" name="tipus" id="tipus">
				<% Set<String> tipus = (Set<String>) (Set<?>) request.getAttribute("tipus");
					for (String t: tipus){
				%>	
					<option><%=t %></option>
				<%
					}
				%>
			   
			</select>
		</div>
		</div>
	</div>
</div>