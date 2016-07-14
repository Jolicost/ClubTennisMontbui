package Presentacio.Components.Gestors.Soci;

import Presentacio.Components.Gestors.VistaInsertIndividual;

public class VistaInsertSoci extends VistaInsertIndividual {

	
	@Override
	protected void createComponents() {
		super.AddComponent(new FormulariSociInsert());
	}

}
