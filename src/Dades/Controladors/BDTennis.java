package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlTennis;
import Domini.Model.Tennis;

public class BDTennis extends Controlador implements CtrlTennis {

	@Override
	public Tennis get(int ID)  throws BDExcepcio {
		return (Tennis)super.get(Tennis.class, ID);
	}

	@Override
	public Set<Tennis> getAll() throws BDExcepcio {
		return (Set<Tennis>) (Set<?>) super.getAll(Tennis.class);
	}

	@Override
	public void Update(Tennis p) throws BDExcepcio {
		super.Update(p);
	}

	@Override
	public void Insert(Tennis p) throws BDExcepcio {
		super.Insert(p);
		
	}
	
	public boolean Exists(int ID) throws BDExcepcio{
		return super.Exists(Tennis.class, ID);
	}
	

	
}
