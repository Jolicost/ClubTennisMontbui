package Presentacio.Main;

import Presentacio.Components.ServletComponent;
import Presentacio.Components.WebComponent;

public class PaginaPujarSocis extends PaginaPrincipal {

	@Override
	protected WebComponent getMainComponent() throws Exception {
		return new ServletComponent("Components/PenjarFitxer/PenjarFitxer.jsp");
	}

}
