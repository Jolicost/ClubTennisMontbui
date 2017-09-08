package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Calendaris.CalendariOcupacions;

public interface CtrlCalendariOcupacions {
	public CalendariOcupacions get(int id) throws BDExcepcio;
	public Set<CalendariOcupacions> getAll() throws BDExcepcio;
	public void Update(CalendariOcupacions c) throws BDExcepcio;
	public void Delete(CalendariOcupacions c) throws BDExcepcio;
	public void Insert(CalendariOcupacions c) throws BDExcepcio;
	public void Delete(int id) throws BDExcepcio;
}
