<jsp:useBean id="info" class="Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva" scope="request"/>
<div class="panel panel-default">
	<div class="panel-body">
		<p><strong>Tipus: </strong>Només Socis</p>
		<ul>
			<li>
				<p>Només pots invitar a socis en aquesta reserva</p>
			</li>
			<li>
				<p>Reserves restants durant la setmana pertanyent a la reserva: <jsp:getProperty name="info" property="quotaActual"/></p>
			</li>
		</ul>
	</div>
</div>