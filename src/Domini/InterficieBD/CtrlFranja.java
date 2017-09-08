package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Reserves.Franja;

public interface CtrlFranja {
	public void Insert(Franja o) throws BDExcepcio;

	public Set<Franja> getAll() throws BDExcepcio;

	public void delete(int id) throws BDExcepcio;

	public Franja get(int id) throws BDExcepcio;

	public void Update(Franja f) throws BDExcepcio;
}
