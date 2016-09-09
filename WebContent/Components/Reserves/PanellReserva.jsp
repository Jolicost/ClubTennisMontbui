
<%@ page import="Communicacio.Dades.Reserves.*" %>
<% InfoReservaSoci i = (InfoReservaSoci) request.getAttribute("info"); %>
<p class="col-md-12">
	<strong>Tipus: </strong>
	<%= i.getTipus() %>
</p>
<p class="col-md-12">
	<strong>Propietari: </strong>
	<%= i.getNomSoci() %>
</p>
<p class="col-md-12">
	<strong>Pista: </strong>
	<%= i.getNomPista() %>
</p>
<p class="col-md-12">
	<strong>Esport: </strong>
	<%= i.getEsport() %>
</p>
<p class="col-md-12">
	<strong>Data: </strong>
	<%= i.getDiaFormat() %>
</p>
<p class="col-md-6">
	<strong>Inici: </strong>
	<%= i.getIniciFormat() %>
</p>
<p class="col-md-6">
	<strong>Fi: </strong>
	<%= i.getFiFormat() %>
</p>
<% if (i.isCancelable()){
%>
	<button type="button" franja=<%= i.getIdFranja() %> class="cancelar-reserva btn btn-default col-xs-offset-3 col-xs-6">
	Cancel·lar Reserva
	</button>


<%} %>
