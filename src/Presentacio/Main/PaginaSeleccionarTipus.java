package Presentacio.Main;

import Presentacio.Components.ServletComponent;
import Presentacio.Components.WebComponent;

public class PaginaSeleccionarTipus extends PaginaPrincipal{



	@Override
	protected WebComponent getMainComponent() {
		return new ServletComponent("Components/TipusReserva/SeleccionarTipus.jsp");
	}

}
