package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlCalendari;
import Domini.Model.Calendari;

public class BDCalendari extends Controlador implements CtrlCalendari {

	@Override
	public Calendari get(int ID) throws BDExcepcio {
		return (Calendari) super.get(Calendari.class, ID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Calendari> getAll() throws BDExcepcio {
		return (Set<Calendari>) (Set<?>) super.getAll(Calendari.class);
	}

	@Override
	public void Update(Calendari c) throws BDExcepcio {
		super.Update(c);
	}

	@Override
	public void Insert(Calendari c) throws BDExcepcio {
		super.Insert(c);
	}

	@Override
	public void Delete(Calendari c) throws BDExcepcio {
		super.Delete(c);
	}

	@Override
	public void Delete(int id) throws BDExcepcio {
		super.Delete(Calendari.class, id);
	}

}
