package Communicacio.Xarxa.Domini.Entitats;

import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.InsuficientPermis;
import Communicacio.Excepcions.NoTeGestor;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.CasosUs.Sessio.CasUsSessio;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;

public class EntitatReserva extends Entitat {

	@Override
	public String getEntitat() {
		return "reserva";
	}
	@Override
	public VistaGestorEntitat getGestorEntitat() {
		return null;
	}

	@Override
	public GestorColectiu getGestor() throws NoTeGestor{
		// TODO Auto-generated method stub
		return null;
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
