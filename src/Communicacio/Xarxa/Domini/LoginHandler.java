package Communicacio.Xarxa.Domini;

import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Sessio.CasUsLogin;
import Domini.CasosUs.Sessio.CasUsSessio;
import Domini.Excepcions.ContrasenyaIncorrecta;
import Domini.Model.Usuari;

public class LoginHandler {

	private CasUsSessio result;
	private String correu;
	private String pass;
	public CasUsSessio getResult(){
		return result;
	}
	public LoginHandler(String correu,String pass){ 
		this.correu = correu;
		this.pass = pass;
	}
	
	public void Execute() throws ContrasenyaIncorrecta, BDExcepcio{
		CasUsLogin l = new CasUsLogin();
		Usuari u = l.Login(correu, pass);
		result = new CasUsSessio(u.crearActor());
	}
	
	
}
