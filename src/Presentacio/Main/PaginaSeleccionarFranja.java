package Presentacio.Main;

import Presentacio.Components.WebComponent;
import Presentacio.Components.Reserves.VistaSeleccionarFranja;

public class PaginaSeleccionarFranja extends PaginaPrincipal{

	@Override
	protected WebComponent getMainComponent() {
		return new VistaSeleccionarFranja();
	}

}
