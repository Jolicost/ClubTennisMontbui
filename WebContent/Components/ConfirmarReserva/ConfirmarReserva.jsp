<jsp:useBean id="info" class="Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva" scope="request"/>
<%@ page import="Communicacio.Dades.Reserves.Confirmar.*" %>
<div id="tipusreserva" class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
		
			<%
				String view;
				InfoConfirmarReserva jinfo = (InfoConfirmarReserva) request.getAttribute("info");
				view = jinfo.getView();
			%>
			<jsp:include page="<%= view %>"/>
			
			
			<div class="panel panel-default">
				<div class="panel-body">
					<p class="col-md-12">
						<strong>Dia: </strong>
						<jsp:getProperty name="info" property="diaFormat"/>
					</p>
					<p class="col-md-6">
						<strong>Inici: </strong>
						<jsp:getProperty name="info" property="iniciFormat"/>
					</p>
					<p class="col-md-6">
						<strong>Fi: </strong>
						<jsp:getProperty name="info" property="fiFormat"/>
					</p>
					<p class="col-md-12">
						<strong>Esport: </strong>
						<jsp:getProperty name="info" property="esport"/>
					</p>
					<p class="col-md-12">
						<strong>Pista: </strong>
						<jsp:getProperty name="info" property="nomPista"/>
					</p>
					
					<jsp:include page="/Components/Botons/botolinksimple.jsp">
					<jsp:param value="ConfirmarReserva" name="submit"/>
					<jsp:param value="confirmar" name="id"/>
					<jsp:param value="null" name="value"/>
					<jsp:param value="null" name="param"/>
					</jsp:include>
					<button type="button" id="confirmar" class="btn btn-default col-xs-offset-4">Confirmar Reserva</button>
			
				</div>	
			</div>
			
			
		</div>
	</div>
</div>
