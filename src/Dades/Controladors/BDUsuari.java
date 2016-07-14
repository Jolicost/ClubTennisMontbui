package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Dades.Excepcions.NoExisteix;
import Domini.InterficieBD.CtrlUsuari;
import Domini.Model.Usuari;

public class BDUsuari extends Controlador implements CtrlUsuari {


	@Override
	public void Update(Usuari u) throws BDExcepcio {
		super.Update(u);
	}

	@Override
	public void Insert(Usuari u) throws BDExcepcio {
		super.Insert(u);
		
	}

	@Override
	public Usuari get(String correu)  throws BDExcepcio {
		Usuari u = (Usuari)super.get(Usuari.class, correu);
		if (u !=null) return u;
		else throw new NoExisteix();
	}
	
	public Set<Usuari> getAll() throws BDExcepcio{
		return (Set<Usuari>) (Set<?>) super.getAll(Usuari.class);
	}

	@Override
	public void Delete(String correu)  throws BDExcepcio {
		super.Delete(Usuari.class,correu);
	}

	

	
}
