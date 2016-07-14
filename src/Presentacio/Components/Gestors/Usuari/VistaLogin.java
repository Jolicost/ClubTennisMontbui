package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.Gestors.VistaIndividual;

public class VistaLogin extends VistaIndividual{

	@Override
	protected void createComponents() throws Exception {
		super.AddComponent(new FormulariLogin());
	}

}
