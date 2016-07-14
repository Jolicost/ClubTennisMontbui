<jsp:useBean id="info" class="Communicacio.Dades.Reserves.InfoReservaSoci" scope="request"/>

<p class="col-md-12">
	<strong>Tipus: </strong>
	<jsp:getProperty name="info" property="tipus"/>
</p>
<p class="col-md-12">
	<strong>Propietari: </strong>
	<jsp:getProperty name="info" property="nomSoci"/>
</p>
<p class="col-md-12">
	<strong>Pista: </strong>
	<jsp:getProperty name="info" property="nomPista"/>
</p>
<p class="col-md-12">
	<strong>Esport: </strong>
	<jsp:getProperty name="info" property="esport"/>
</p>
<p class="col-md-12">
	<strong>Data: </strong>
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