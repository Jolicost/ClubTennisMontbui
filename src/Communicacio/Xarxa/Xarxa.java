package Communicacio.Xarxa;

import Communicacio.Identificacio.Identificacio;
import Communicacio.Xarxa.Domini.LoginHandler;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.Excepcions.ContrasenyaIncorrecta;

public abstract class Xarxa {

	
	public Xarxa(){
	}
	
	public ResultatCasUs FerCasDUs(Identificacio id,CasUs cu) throws Exception{
		return id.getSessio().FerCasDUs(cu);
	}
	
	
	public ResultatCasUs FerCasDUsIndividual(Identificacio id,CasUs cu) throws Exception{
		return id.getSessio().FerCasDUsIndividual(cu);
	}
	
	public void Login(Identificacio id,String user,String pass) throws ContrasenyaIncorrecta, BDExcepcio{
		  LoginHandler h = new LoginHandler(user,pass);
		  h.Execute();
		  id.setCasUs(h.getResult());
	}
	
	public String getEntitatGestor(Identificacio id) throws Exception {
		return id.getSessio().getEntitatGestor();
	}
	
	public void Logout(Identificacio id){
		id.Logout();
	}
}
