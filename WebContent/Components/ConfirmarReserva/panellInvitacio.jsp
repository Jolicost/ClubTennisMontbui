<jsp:useBean id="info" class="Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva" scope="request"/>
<div class="panel panel-default">
	<div class="panel-body">
		<p><strong>Tipus: </strong>Invitació</p>
		<ul>
			<li>
				<p>Pots invitar a jugar a qualsevol persona en la pista durant aquesta reserva</p>
			</li>
			<li>
				<p>Invitacions restants durant el mes pertanyent a la reserva: <jsp:getProperty name="info" property="quotaActual"/></p>
			</li>
		</ul>
	</div>
</div>