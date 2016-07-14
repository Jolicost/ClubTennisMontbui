package Presentacio.Components.Gestors.Pista;

import Presentacio.Components.Gestors.VistaInsertIndividual;

public class VistaInsertPista extends VistaInsertIndividual {

	@Override
	protected void createComponents() {
		super.AddComponent(new FormulariInsertPista());
	}

}
