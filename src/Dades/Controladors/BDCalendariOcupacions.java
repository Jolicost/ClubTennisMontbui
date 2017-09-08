package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlCalendariOcupacions;
import Domini.Model.Calendaris.CalendariOcupacions;

public class BDCalendariOcupacions extends Controlador implements CtrlCalendariOcupacions {

	@Override
	public CalendariOcupacions get(int ID) throws BDExcepcio{
		return (CalendariOcupacions)super.get(CalendariOcupacions.class, ID);
	}

	@Override
	public Set<CalendariOcupacions> getAll() throws BDExcepcio {
		return (Set<CalendariOcupacions>) (Set<?>) super.getAll(CalendariOcupacions.class);
	}

	@Override
	public void Update(CalendariOcupacions p) throws BDExcepcio {
		super.Update(p);
	}

	@Override
	public void Insert(CalendariOcupacions p) throws BDExcepcio {
		super.Insert(p);
		
	}

	@Override
	public void Delete(CalendariOcupacions c) throws BDExcepcio {
		super.Delete(c);
	}

	@Override
	public void Delete(int id) throws BDExcepcio {
		super.Delete(CalendariOcupacions.class, id);
	}

	

	
}
