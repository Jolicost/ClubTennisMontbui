package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoObertura;
import Communicacio.Excepcions.NoTeGestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Presentacio.Components.Gestors.VistaCRUDObertures;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;
import Presentacio.Components.Gestors.Obertura.VistaInsertObertura;
import Presentacio.Components.Gestors.Obertura.VistaUpdateObertura;

public class EntitatObertura extends Entitat {

	@Override
	public String getEntitat() {
		return "obertura";
	}

	@Override
	public VistaGestorEntitat getGestorEntitat() {
		return new VistaCRUDObertures();
	}

	@Override
	public GestorColectiu getGestor() throws NoTeGestor {
		throw new NoTeGestor();
	}

	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Info getInfo() {
		return new InfoObertura();
	}

	@Override
	public VistaGestorIndividual getGestorIndividual() {
		return new VistaUpdateObertura();
	}

	@Override
	public VistaInsertIndividual getInsertIndividual() {
		return new VistaInsertObertura();
	}

}
