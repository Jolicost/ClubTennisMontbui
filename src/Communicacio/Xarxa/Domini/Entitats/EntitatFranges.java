package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.NoTeGestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.CasosUs.Gestors.Franges.GestorFrangesTotal;
import Presentacio.Components.Gestors.VistaCRUDFranges;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;

public class EntitatFranges extends Entitat {

	@Override
	public String getEntitat() {
		return "franges";
	}

	@Override
	public VistaGestorEntitat getGestorEntitat() {
		return new VistaCRUDFranges();
	}

	@Override
	public GestorColectiu getGestor() throws NoTeGestor {
		return new GestorFrangesTotal();
	}

	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Info getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VistaGestorIndividual getGestorIndividual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VistaInsertIndividual getInsertIndividual() {
		// TODO Auto-generated method stub
		return null;
	}

}
