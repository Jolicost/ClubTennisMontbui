package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlAnticipada;
import Domini.Model.Reserves.Anticipada;

public class BDAnticipada extends Controlador implements CtrlAnticipada {

	@Override
	public Set<Anticipada> getAll() throws BDExcepcio {
		return (Set<Anticipada>) (Set<?>) super.getAll(Anticipada.class);
	}

}
