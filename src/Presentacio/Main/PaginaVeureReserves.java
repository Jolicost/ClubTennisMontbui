package Presentacio.Main;

import Presentacio.Components.ServletComponent;
import Presentacio.Components.WebComponent;

public class PaginaVeureReserves extends PaginaPrincipal {

	@Override
	protected WebComponent getMainComponent() {
		return new ServletComponent("Components/Reserves/LlistaReserves.jsp");
	}

}
