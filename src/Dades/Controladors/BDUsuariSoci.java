package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Dades.Excepcions.NoExisteix;
import Domini.InterficieBD.CtrlUsuari;
import Domini.InterficieBD.CtrlUsuariSoci;
import Domini.Model.Usuari;
import Domini.Model.UsuariSoci;

public class BDUsuariSoci extends Controlador implements CtrlUsuariSoci {




	@Override
	public void Insert(UsuariSoci u) throws BDExcepcio {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(UsuariSoci u) throws BDExcepcio {
		
	}

	@Override
	public UsuariSoci get(String correu) throws BDExcepcio {
		return (UsuariSoci) super.get(UsuariSoci.class, correu);
	}

	@Override
	public void Delete(String correu) throws BDExcepcio {

		super.Delete(UsuariSoci.class,correu);
	}
	
	public void Delete(UsuariSoci usuarisoci) throws BDExcepcio{
		super.Delete(usuarisoci);
	}

	@Override
	public void Delete(Usuari u) throws BDExcepcio {
		super.Delete(u);
	}

	@Override
	public Set<UsuariSoci> getAll() throws BDExcepcio {
		return (Set<UsuariSoci>) (Set<?>) super.getAll(UsuariSoci.class);
	}

	

	
}
