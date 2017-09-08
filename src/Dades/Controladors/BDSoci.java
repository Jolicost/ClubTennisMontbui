package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlSoci;
import Domini.Model.Soci;

public class BDSoci extends Controlador implements CtrlSoci {

	@Override
	public Soci get(String ID)  throws BDExcepcio{
		return (Soci)super.get(Soci.class, ID);
	}

	@Override
	public void Update(Soci p) throws BDExcepcio {
		super.Update(p);
	}

	@Override
	public void Insert(Soci p) throws BDExcepcio{
		super.Insert(p);
		
	}

	@Override
	public Soci get(int id)  throws BDExcepcio{
		return (Soci)super.get(Soci.class, id);
	}

	@Override
	public void Delete(int id) throws BDExcepcio {
		super.Delete(Soci.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Soci> getAll() throws BDExcepcio {
		return (Set<Soci>) (Set<?>) super.getAll(Soci.class);
	}

	

	
}
