package Domini.InterficieBD;

import java.io.Serializable;
import java.util.Set;

import Communicacio.Dades.Info;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Reserves.Franja;
import Domini.Model.Reserves.Ocupacio;

public interface CtrlFranja {
	public void Insert(Franja o) throws BDExcepcio;

	public Set<Franja> getAll() throws BDExcepcio;

	public void delete(int id) throws BDExcepcio;

	public Franja get(int id) throws BDExcepcio;

	public void Update(Franja f) throws BDExcepcio;
}
