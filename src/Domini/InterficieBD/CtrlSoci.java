package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;

public interface CtrlSoci {
	public Soci get(String i)  throws BDExcepcio;
	public Soci get(int id)  throws BDExcepcio;
	public void Insert(Soci s) throws BDExcepcio;
	public void Update(Soci s) throws BDExcepcio;
	public void Delete(int id) throws BDExcepcio;
	public Set<Soci> getAll() throws BDExcepcio;
}
