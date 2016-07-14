<% 
String dispacher = request.getParameter("dispacher");
if (dispacher == null) dispacher= "submit";

String[] dies = {"Dilluns","Dimarts","Dimecres","Dijous","Divendres","Dissabte","Diumenge"};
%>
<script src="Components/Obertures/AfegirObertures.js"></script>
<div id="AfegirObertures" class="container" dispacher="<%= dispacher %>">
	<div class="row">
		
		<% for (int i = 0; i < dies.length; i++){
			%>
			<div class="col-md-3">
				<jsp:include page="DiaSetmana.jsp">
				<jsp:param name="NumeroDia" value="<%=i+1%>"/>
				<jsp:param name="DiaSetmana" value="<%= dies[i] %>"/>
				</jsp:include>
			</div>
		<%	
		}%>
		<div class="col-md-3">
			<jsp:include page="./IntervalDia.jsp"/>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">

			<button id="acceptar" type="button" class="btn btn-default col-xs-4 col-xs-offset-4">Acceptar</button>

		</div>
	</div>
</div>

