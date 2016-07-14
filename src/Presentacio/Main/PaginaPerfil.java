package Presentacio.Main;

import Presentacio.Components.ServletComponent;
import Presentacio.Components.WebComponent;

public class PaginaPerfil extends PaginaPrincipal{

	@Override
	protected WebComponent getMainComponent() throws Exception {
		return new ServletComponent("Components/Perfil/Perfil.jsp");
	}

}
