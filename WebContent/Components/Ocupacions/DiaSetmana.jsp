<% String dia = request.getParameter("NumeroDia");%>
<div class="DiaSetmana" dia="<%= dia%>">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="text-center text-muted HeaderDia"><%= request.getParameter("DiaSetmana") %></h3>
		</div>
		<div class="panel-body">
			<div class="form-group">
		  		<label for="inici_<%=dia %>">Inici:</label>
		  		<input type="time" name="inici" class="form-control" id="inici_<%=dia%>">
			</div>
			<div class="form-group">
		  		<label for="fi_<%=dia%>">Fi:</label>
		  		<input type="time" name="fi" class="form-control" id="fi_<%=dia%>">
			</div>
			<div class="botonsDia">
				<div class="col-xs-6">
					<button class="btn btn-default duplicar">Duplicar</button>
				</div>
				<div class="col-xs-6">
					<button class="btn btn-default eliminar">Eliminar</button>
				</div>
			</div>
		</div>
	</div>
</div>