package Presentacio.Components.Gestors.Calendari;

import Presentacio.Components.Gestors.VistaInsertIndividual;

public class VistaInsertCalendari extends VistaInsertIndividual{

	@Override
	protected void createComponents() {
		super.AddComponent(new FormulariInsertCalendari());
	}

}
