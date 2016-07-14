package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlFranja;
import Domini.Model.Reserves.Franja;

public class BDFranja extends Controlador implements CtrlFranja {

	@Override
	public void Insert(Franja f) throws BDExcepcio {
		super.Insert(f);
		
	}

	@Override
	public Set<Franja> getAll() throws BDExcepcio {
		return (Set<Franja>) (Set<?>) super.getAll(Franja.class);
	}

	@Override
	public void delete(int id) throws BDExcepcio {
		super.Delete(Franja.class, id);
	}

	@Override
	public Franja get(int id) throws BDExcepcio {
		return (Franja) super.get(Franja.class, id);
	}

	@Override
	public void Update(Franja f) throws BDExcepcio {
		super.Update(f);
	}


	

	
}
