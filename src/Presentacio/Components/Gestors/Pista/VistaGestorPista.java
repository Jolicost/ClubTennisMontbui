package Presentacio.Components.Gestors.Pista;

import java.util.List;

import Communicacio.Dades.Info;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.VistaGestorIndividual;

public class VistaGestorPista extends VistaGestorIndividual {

	@Override
	protected WebComponent getFormulari() {
		Info i = (Info) super.io.getParam("individual");
		return new FormulariUpdatePista(i);
	}

	@Override
	protected void afegirBotons(List<WebComponent> botons) {
		botons.add(new BotoGestionarOcupacions());
		botons.add(new BotoAssignarCalendari());
		botons.add(new BotoAfegirOcupacions());
	}

}
