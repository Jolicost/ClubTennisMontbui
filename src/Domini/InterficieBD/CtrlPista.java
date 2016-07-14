package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Pista;

public interface CtrlPista {
	public Pista get(int ID) throws BDExcepcio;
	public Set<Pista> getAll() throws  BDExcepcio;
	public void Update(Pista p) throws BDExcepcio;
	public void Insert(Pista p) throws BDExcepcio;
	public void Delete(int id) throws BDExcepcio;
}
