package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoCalendari;
import Communicacio.Excepcions.NoTeGestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.CasosUs.Gestors.Calendaris.GestorCalendaris;
import Presentacio.Components.Gestors.VistaCRUDCalendaris;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectCalendari;
import Presentacio.Components.Gestors.VistaSelectEntitat;
import Presentacio.Components.Gestors.Calendari.VistaGestorCalendari;
import Presentacio.Components.Gestors.Calendari.VistaInsertCalendari;

public class EntitatCalendari extends Entitat {

	@Override
	public String getEntitat() {
		return "calendari";
	}



	@Override
	public VistaGestorEntitat getGestorEntitat() {
		return new VistaCRUDCalendaris();
	}



	@Override
	public GestorColectiu getGestor() throws NoTeGestor{
		return new GestorCalendaris();
	}



	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		return new VistaSelectCalendari();
	}



	@Override
	public Info getInfo() {
		return new InfoCalendari();
	}



	@Override
	public VistaGestorIndividual getGestorIndividual() {
		return new VistaGestorCalendari();
	}



	@Override
	public VistaInsertIndividual getInsertIndividual() {
		return new VistaInsertCalendari();
	}

}
