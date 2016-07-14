package Presentacio.Main;

import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.Usuari.FormulariLogin;
import Presentacio.Components.Gestors.Usuari.VistaLogin;

public class PaginaLogin extends PaginaPrincipal {

	@Override
	protected WebComponent getMainComponent() {
		return new VistaLogin();
	}

}
