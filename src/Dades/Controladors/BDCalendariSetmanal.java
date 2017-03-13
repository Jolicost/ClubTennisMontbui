package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlCalendariSetmanal;
import Domini.Model.Calendaris.CalendariSetmanal;

public class BDCalendariSetmanal extends Controlador implements CtrlCalendariSetmanal {

	@Override
	public CalendariSetmanal get(int ID) throws BDExcepcio{
		return (CalendariSetmanal)super.get(CalendariSetmanal.class, ID);
	}

	@Override
	public Set<CalendariSetmanal> getAll() throws BDExcepcio {
		return (Set<CalendariSetmanal>) (Set<?>) super.getAll(CalendariSetmanal.class);
	}

	@Override
	public void Update(CalendariSetmanal p) throws BDExcepcio {
		super.Update(p);
	}

	@Override
	public void Insert(CalendariSetmanal p) throws BDExcepcio {
		super.Insert(p);
		
	}

	@Override
	public void Delete(CalendariSetmanal c) throws BDExcepcio {
		super.Delete(c);
	}

	@Override
	public void Delete(int id) throws BDExcepcio {
		super.Delete(CalendariSetmanal.class, id);
	}

	

	
}
