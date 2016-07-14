<%@ page import="Communicacio.Dades.Reserves.*" %>
<%@ page import="java.util.*" %>
<div class="container">
<div class="row">
<%
	SortedSet<InfoFranja> reserves = (SortedSet<InfoFranja>) (SortedSet<?>) request.getAttribute("reserves");
	for (InfoFranja i: reserves){
		request.setAttribute("info",i);
		%>
		<div class="col col-md-4">
			<div class="panel panel-default">
				<div class="panel-body">
  					<jsp:include page="PanellReserva.jsp"/>
  				</div>
			</div>	
		</div>
<%	
	}
%>
</div>
</div>
