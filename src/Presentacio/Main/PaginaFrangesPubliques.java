package Presentacio.Main;

import Presentacio.Components.ServletComponent;
import Presentacio.Components.WebComponent;

public class PaginaFrangesPubliques extends PaginaPrincipal {

	@Override
	protected WebComponent getMainComponent() throws Exception {
		return new ServletComponent("Components/Calendari/calendariPublic.jsp");
	}

}
