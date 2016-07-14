package Presentacio.Components.Gestors.Obertura;

import Presentacio.Components.Gestors.VistaInsertIndividual;

public class VistaInsertObertura extends VistaInsertIndividual{

	@Override
	protected void createComponents() {
		super.AddComponent(new FormulariOberturaInsert());
	}

}
