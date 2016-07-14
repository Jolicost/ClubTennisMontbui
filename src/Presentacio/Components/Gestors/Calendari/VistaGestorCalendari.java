package Presentacio.Components.Gestors.Calendari;

import java.util.List;

import Communicacio.Dades.Info;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.VistaGestorIndividual;

public class VistaGestorCalendari extends VistaGestorIndividual {



	@Override
	protected WebComponent getFormulari() {
		Info i = (Info) super.io.getParam("individual");
		return new FormulariUpdateCalendari(i);
	}

	@Override
	protected void afegirBotons(List<WebComponent> botons) {
		
		botons.add(new BotoGestionarObertures());
		botons.add(new BotoAfegirLotsObertures());
	}

}
