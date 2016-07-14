package Presentacio.Main;

import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.Usuari.FormulariRegistre;
import Presentacio.Components.Gestors.Usuari.VistaRegistre;

public class PaginaRegistre extends PaginaPrincipal {

	@Override
	protected WebComponent getMainComponent() {
		return new VistaRegistre();
	}

}
