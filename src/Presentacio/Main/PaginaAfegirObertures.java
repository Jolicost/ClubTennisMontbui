package Presentacio.Main;

import Presentacio.Components.ServletComponent;
import Presentacio.Components.WebComponent;

public class PaginaAfegirObertures extends PaginaPrincipal {

	@Override
	protected WebComponent getMainComponent() {
		return new ServletComponent("Components/Obertures/AfegirObertures.jsp");
	}

}
