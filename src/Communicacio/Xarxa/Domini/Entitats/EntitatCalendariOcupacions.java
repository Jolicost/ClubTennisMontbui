package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoCalendariOcupacions;
import Communicacio.Excepcions.NoTeGestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.CasosUs.Gestors.CalendariSetmanal.GestorCalendariOcupacions;
import Presentacio.Components.Gestors.VistaCRUDCalendarisSetmanals;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;
import Presentacio.Components.Gestors.CalendariSetmanal.VistaGestorCalendariSetmanal;
import Presentacio.Components.Gestors.CalendariSetmanal.VistaInsertCalendariSetmanal;

public class EntitatCalendariOcupacions extends Entitat {

	@Override
	public String getEntitat() {
		return "calendariocupacions";
	}

	@Override
	public VistaGestorEntitat getGestorEntitat() {
		return new VistaCRUDCalendarisSetmanals();
	}

	@Override
	public GestorColectiu getGestor() throws NoTeGestor {
		return new GestorCalendariOcupacions();
	}

	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Info getInfo() {
		return new InfoCalendariOcupacions();
	}

	@Override
	public VistaGestorIndividual getGestorIndividual() {
		return new VistaGestorCalendariSetmanal();
	}

	@Override
	public VistaInsertIndividual getInsertIndividual() {
		return new VistaInsertCalendariSetmanal();
	}

}
