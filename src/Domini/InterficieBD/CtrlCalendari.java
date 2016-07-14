package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Calendari;

public interface CtrlCalendari {

	public Calendari get(int ID) throws BDExcepcio;
	public Set<Calendari> getAll() throws  BDExcepcio;
	public void Update(Calendari c) throws BDExcepcio;
	public void Insert(Calendari c) throws BDExcepcio;
	public void Delete(Calendari c) throws BDExcepcio;
	public void Delete(int id) throws BDExcepcio;
}
