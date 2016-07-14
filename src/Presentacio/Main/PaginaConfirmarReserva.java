package Presentacio.Main;

import Presentacio.Components.ServletComponent;
import Presentacio.Components.WebComponent;

public class PaginaConfirmarReserva extends PaginaPrincipal {

	@Override
	protected WebComponent getMainComponent() {
		return new ServletComponent("/Components/ConfirmarReserva/ConfirmarReserva.jsp");
	}

}
