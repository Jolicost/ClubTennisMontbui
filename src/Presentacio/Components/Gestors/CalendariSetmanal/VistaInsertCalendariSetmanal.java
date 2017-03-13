package Presentacio.Components.Gestors.CalendariSetmanal;

import Presentacio.Components.Gestors.VistaInsertIndividual;

public class VistaInsertCalendariSetmanal extends VistaInsertIndividual{

	@Override
	protected void createComponents() throws Exception {
		super.AddComponent(new FormulariInsertCalendariSetmanal());
	}

}
