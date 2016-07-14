package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoSoci;
import Communicacio.Excepcions.NoTeGestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.CasosUs.Gestors.Socis.GestorSocis;
import Presentacio.Components.Gestors.VistaCRUDSocis;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;
import Presentacio.Components.Gestors.VistaSelectSoci;
import Presentacio.Components.Gestors.Soci.VistaInsertSoci;
import Presentacio.Components.Gestors.Soci.VistaUpdateSoci;

public class EntitatSoci extends Entitat{

	@Override
	public String getEntitat() {
		return "soci";
	}


	@Override
	public VistaGestorEntitat getGestorEntitat() {
		return new VistaCRUDSocis();
	}


	@Override
	public GestorColectiu getGestor() throws NoTeGestor {
		return new GestorSocis();
	}


	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		return new VistaSelectSoci();
	}


	@Override
	public Info getInfo() {
		return new InfoSoci();
	}


	@Override
	public VistaGestorIndividual getGestorIndividual() {
		return new VistaUpdateSoci();
	}


	@Override
	public VistaInsertIndividual getInsertIndividual() {
		return new VistaInsertSoci();
	}

}
