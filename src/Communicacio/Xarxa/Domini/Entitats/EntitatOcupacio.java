package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Communicacio.Excepcions.NoTeGestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.CasosUs.Gestors.Franges.GestorOcupacions;
import Presentacio.Components.Gestors.VistaCRUDOcupacions;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;
import Presentacio.Components.Gestors.Ocupacions.VistaInsertOcupacio;
import Presentacio.Components.Gestors.Ocupacions.VistaUpdateOcupacio;

public class EntitatOcupacio extends Entitat {

	@Override
	public String getEntitat() {
		return "ocupacio";
	}

	@Override
	public VistaGestorEntitat getGestorEntitat() {
		return new VistaCRUDOcupacions();
	}

	@Override
	public GestorColectiu getGestor() throws NoTeGestor {
		return new GestorOcupacions();
	}

	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Info getInfo() {
		return new InfoOcupacio();
	}

	@Override
	public VistaGestorIndividual getGestorIndividual() {
		return new VistaUpdateOcupacio();
	}

	@Override
	public VistaInsertIndividual getInsertIndividual() {
		return new VistaInsertOcupacio();
	}

}
