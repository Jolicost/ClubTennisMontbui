<%@ page import="Communicacio.Dades.InfoUsuari" %>
<% InfoUsuari iu = (InfoUsuari) request.getAttribute("individual"); %>
<div class="panel panel-default">
	<div class="panel-body">
		<p class="col-md-12">
			<strong>Correu: </strong>
			<%= iu.getEmail() %>
		</p>
		<p class="col-md-12">
			<strong>Nom: </strong>
			<%= iu.getNom() %>
		</p>
		<p class="col-md-12">
			<strong>Cognoms: </strong>
			<%= iu.getCognoms() %>
		</p>
		<p class="col-md-12">
			<strong>Dni: </strong>
			<%= iu.getDni() %>
		</p>
		<% if (iu.getNsoci() != null){ %>
			<p class="col-md-12">
				<strong>Número de soci: </strong>
				<%= iu.getNsoci() %>
			</p>
		<% } 
		else{ %>
			<p class="col-md-12">
				<strong>No ets soci</strong>
			</p>
		<%}%>
	</div>
</div>