package Presentacio.Components.Gestors.Usuari;

import java.util.List;

import Communicacio.Dades.Info;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.VistaGestorIndividual;

public class VistaGestorUsuari extends VistaGestorIndividual{

	@Override
	protected WebComponent getFormulari() {
		Info i = (Info) super.io.getParam("individual");
		return new FormulariGestorUsuari(i);
	}

	@Override
	protected void afegirBotons(List<WebComponent> botons) {
		Info i = (Info) super.io.getParam("individual");
		botons.add(new NSociEditor(i.getAttribute("nsoci")));
	}
	
}
