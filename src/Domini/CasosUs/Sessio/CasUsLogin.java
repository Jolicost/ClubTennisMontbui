package Domini.CasosUs.Sessio;

import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.ContrasenyaIncorrecta;
import Domini.Model.Usuari;
import Factories.FactoriaControladors;

public class CasUsLogin {
	
	public Usuari Login(String correu,String pass) throws ContrasenyaIncorrecta, BDExcepcio{
		Usuari ret = FactoriaControladors.getInstance().getCtrlUsuari().get(correu);
		if (!ret.getPass().equals(pass)) throw new ContrasenyaIncorrecta();
		return ret;		
	}

}
