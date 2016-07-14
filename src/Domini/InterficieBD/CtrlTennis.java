package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Tennis;

public interface CtrlTennis {
	public Tennis get(int ID) throws BDExcepcio;
	public Set<Tennis> getAll() throws BDExcepcio;
	public void Update(Tennis t) throws BDExcepcio;
	public void Insert(Tennis t) throws BDExcepcio;
	public boolean Exists(int ID) throws BDExcepcio;
}
