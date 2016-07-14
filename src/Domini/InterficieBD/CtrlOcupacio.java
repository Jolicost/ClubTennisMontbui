package Domini.InterficieBD;

import java.util.Set;

import Communicacio.Dades.Info;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Reserves.Ocupacio;

public interface CtrlOcupacio {
	public void Insert(Ocupacio o) throws BDExcepcio;

	public Ocupacio Get(int id) throws BDExcepcio;

	public Set<Ocupacio> getAll() throws BDExcepcio;
}
