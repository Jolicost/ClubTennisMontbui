<%@ page import="java.util.*" %>
<%@ page import="Communicacio.Dades.Reserves.Tipus.*" %>
<% Set<InfoTipusReserva> tipus = (Set<InfoTipusReserva>) (Set<?>)request.getAttribute("tipus"); %>
<div id="tipusreserva" class="container">
  <div class="row">
    <% int j = 0;
  			for (InfoTipusReserva itr: tipus){
  				if (itr.getPanelFile() != null){%>
  					<div class="col-md-4">
  						<div class="panel panel-default">
						<div class="panel-body">
						
						<jsp:include page="/Components/Botons/botolinksimple.jsp">
						<jsp:param value="SeleccionarTipus" name="submit"/>
						<jsp:param value="<%= itr.getTipus() %>" name="id"/>
						<jsp:param value="<%= itr.getTipus() %>" name="value"/>
						<jsp:param value="tipus" name="param"/>

						</jsp:include>
		  				<jsp:include page="<%= itr.getPanelFile() %>">
		  				<jsp:param name="tipusReserva" value="<%= itr.getTipus() %>"/>
						<jsp:param name="restants" value="<%=itr.getRestants()%>"/>
						</jsp:include>
						
						<button type="button" id="<%= itr.getTipus() %>" class="btn btn-default col-xs-offset-4">Seleccionar</button>
						
						</div>
						</div>
					</div>
  		<%
  				}
  		j++;
  		}  	
  	%>
  </div>
</div>

