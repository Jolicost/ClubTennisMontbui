package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlPista;
import Domini.Model.Pista;

public class BDPista extends Controlador implements CtrlPista {

	@Override
	public Pista get(int ID) throws BDExcepcio{
		return (Pista)super.get(Pista.class, ID);
	}

	@Override
	public Set<Pista> getAll() throws BDExcepcio {
		return (Set<Pista>) (Set<?>) super.getAll(Pista.class);
	}

	@Override
	public void Update(Pista p) throws BDExcepcio {
		super.Update(p);
	}

	@Override
	public void Insert(Pista p) throws BDExcepcio {
		super.Insert(p);
		
	}

	@Override
	public void Delete(int id) throws BDExcepcio {
		super.Delete(Pista.class,id);
	}
	

	
}
