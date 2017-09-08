package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Dades.Reserves.InfoReserva;
import Communicacio.Excepcions.NoTeGestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;
import Presentacio.Components.Gestors.Franges.Reserves.VistaUpdateReserva;

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
		throw new NoTeGestor();
	}
	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Info getInfo() {
		return new InfoReserva();
	}
	@Override
	public VistaGestorIndividual getGestorIndividual() {
		return new VistaUpdateReserva();
	}
	@Override
	public VistaInsertIndividual getInsertIndividual() {
		// TODO Auto-generated method stub
		return null;
	}

}
