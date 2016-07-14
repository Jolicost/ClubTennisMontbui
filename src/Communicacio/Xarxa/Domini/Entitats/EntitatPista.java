package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoPista;
import Communicacio.Excepcions.NoTeGestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.CasosUs.Gestors.Pistes.GestorPistes;
import Presentacio.Components.Gestors.VistaCRUDPistes;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;
import Presentacio.Components.Gestors.Pista.VistaGestorPista;
import Presentacio.Components.Gestors.Pista.VistaInsertPista;

public class EntitatPista extends Entitat {

	
	@Override
	public String getEntitat() {
		return "pista";
	}

	@Override
	public VistaGestorEntitat getGestorEntitat() {
		return new VistaCRUDPistes();
	}

	@Override
	public GestorColectiu getGestor()throws NoTeGestor {
		return new GestorPistes();
	}

	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Info getInfo() {
		return new InfoPista();
	}

	@Override
	public VistaGestorIndividual getGestorIndividual() {
		return new VistaGestorPista();
	}

	@Override
	public VistaInsertIndividual getInsertIndividual() {
		return new VistaInsertPista();
	}

}
