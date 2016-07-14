package Presentacio.Main;

import Presentacio.Components.EmptyComponent;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.Usuari.FormulariLogin;

public class PaginaHome extends PaginaPrincipal{

	@Override
	protected WebComponent getMainComponent() {
		return new EmptyComponent();
	}

}
