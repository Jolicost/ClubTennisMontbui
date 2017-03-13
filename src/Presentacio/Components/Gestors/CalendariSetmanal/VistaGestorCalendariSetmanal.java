package Presentacio.Components.Gestors.CalendariSetmanal;

import Communicacio.Dades.InfoCalendariOcupacions;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.VistaGestorIndividual;

public class VistaGestorCalendariSetmanal extends VistaGestorIndividual {

	@Override
	protected WebComponent getFormulari() {
		return new FormulariUpdateCalendariSetmanal((InfoCalendariOcupacions)super.io.getParam("individual"));
	}
	




}
