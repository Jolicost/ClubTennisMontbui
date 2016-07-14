package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Reserves.Anticipada;

public interface CtrlAnticipada {
	public Set<Anticipada> getAll() throws BDExcepcio;
}
