package Presentacio.Components.Gestors.Ocupacions;

import Presentacio.Components.Gestors.VistaInsertIndividual;

public class VistaInsertOcupacio extends VistaInsertIndividual{

	@Override
	protected void createComponents() {
		super.AddComponent(new FormulariOcupacioInsert());
	}

}
