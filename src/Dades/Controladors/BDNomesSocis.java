package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlNomesSocis;
import Domini.Model.Pista;
import Domini.Model.Reserves.NomesSocis;

public class BDNomesSocis extends Controlador implements CtrlNomesSocis{

	@Override
	public Set<NomesSocis> getAll() throws BDExcepcio {
		return (Set<NomesSocis>) (Set<?>) super.getAll(NomesSocis.class);
	}

}
