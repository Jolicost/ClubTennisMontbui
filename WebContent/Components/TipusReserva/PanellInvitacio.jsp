<% 
	String restants = request.getParameter("restants");
%>
<h2 class="text text-center">Invitació</h2>
<ul class="list">
	<li class="list-item">
		<p class="text text-left">Aquest tipus de reserva et permet invitar a qualsevol persona a jugar en les nostres pistes</p>
	</li>
	<li>
		<p class="text text-left">Et queden: <%= restants %> Invitacions aquest mes</p>
	</li>
</ul>




