package Dades.Controladors;

import java.util.Set;

import Communicacio.Dades.Info;
import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlOcupacio;
import Domini.Model.Reserves.Ocupacio;

public class BDOcupacio extends Controlador implements CtrlOcupacio {

	@Override
	public void Insert(Ocupacio o) throws BDExcepcio{
		super.Insert(o);
		
	}

	@Override
	public Ocupacio Get(int id) throws BDExcepcio {
		return (Ocupacio) super.get(Ocupacio.class, id);
	}

	@Override
	public Set<Ocupacio> getAll() throws BDExcepcio {
		return (Set<Ocupacio>) (Set<?>) super.getAll(Ocupacio.class);
	}


	

	
}
