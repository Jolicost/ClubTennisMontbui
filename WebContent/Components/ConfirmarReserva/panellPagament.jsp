<jsp:useBean id="info" class="Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva" scope="request"/>
<div class="panel panel-default">
	<div class="panel-body">
		<p><strong>Tipus: </strong>Pagament</p>
		<ul>
			<li>
				<p>Pots invitar a qualsevol persona que no sigui sòcia, però hauràs d'abonar el preu de la seva part al club</p>
			</li>
			<li>
				<p>Reserves restants en la setmana pertanyent a la reserva: <jsp:getProperty name="info" property="quotaActual"/></p>
			</li>
			<li>
				<p><strong>Preu de la reserva: </strong><jsp:getProperty name="info" property="preu"/> Euros</p>
			</li>
		</ul>
	</div>
</div>