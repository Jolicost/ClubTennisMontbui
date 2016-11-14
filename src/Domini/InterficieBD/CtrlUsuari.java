package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Usuari;

public interface CtrlUsuari {
	public Usuari get(String correu)  throws BDExcepcio;
	public void Insert(Usuari u) throws BDExcepcio;
	public void Update(Usuari u) throws BDExcepcio;
	public void Delete(String correu) throws BDExcepcio;
	public Set<Usuari> getAll() throws BDExcepcio;
	public boolean Exists(String correu) throws BDExcepcio;
}
