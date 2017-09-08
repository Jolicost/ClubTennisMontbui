<div class="container">
	<div class="row">
		<div class="col col-md-4 col-md-offset-4">
		<h3>Escriu la nova contrasenya: </h3>
		<br>
		<script src="Components/Misc/Validator.js"></script>
		<form data-toggle="validator" role="form" method="POST" action="RecuperarContrasenya" class="form" novalidate="true">
		<div>
			<div class="form-group">
				<label for="pass">Password: </label>
				<input name="password" id="pass" type="password" class="form-control" required="true">
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="cpass">Confirmar Pass: </label>
				<input name="cpass" data-match="#pass" id="cpass" type="password" class="form-control" required="true">
				<div class="help-block with-errors"></div>
			</div>
		</div>
		<input id="submit" type="submit" value="Enviar" class="btn btn-default"/>
		</form>
		</div>	
	</div>
</div>