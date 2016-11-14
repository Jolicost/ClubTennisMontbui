<div id="ContrasenyaOlvidada" class="container">
	<div class="row">
		<div class="col col-md-4 col-md-offset-4">
			<h2>Recuperar Contrasenya:</h2>
			<ol>
			<li>
				<p class="text">Introdueix el correu amb el que et vas registrar</p>
			</li>
			<li>
				<p class="text">S'enviar� un correu de verificaci� a l'adre�a indicada</p>
			</li>
			<li>
				<p class="text">Fes click sobre l'enlla� dins del correu i introdueix la nova contrasenya</p>
			</li>			
			</ol>
			<script src="Components/Misc/Validator.js"></script>
			<form action="DemanarCanviPass" method="POST">
			<div class="form-group">
				<label for="email">Email: </label>
				<input name="email" id="email" type="email" class="form-control" required="true"/>
				<div class="help-block with-errors"></div>
			</div>
			<input id="submit" type="submit" value="Enviar" class="btn btn-default"/>			
			</form>
		</div>	
	</div>
</div>