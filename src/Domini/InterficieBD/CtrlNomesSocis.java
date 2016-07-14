package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Reserves.NomesSocis;

public interface CtrlNomesSocis {
	public Set<NomesSocis> getAll() throws BDExcepcio;
}
