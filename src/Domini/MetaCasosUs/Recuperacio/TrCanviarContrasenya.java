package Domini.MetaCasosUs.Recuperacio;

import Domini.Model.Usuari;
import Factories.FactoriaControladors;

public class TrCanviarContrasenya {

	public TrCanviarContrasenya(String key, String pass) {
		super();
		this.key = key;
		this.pass = pass;
	}
	private String key;
	private String pass;
	
	public void Executar() throws Exception{
		String correu = FactoriaRecuperacio.getInstance().getDipositClaus().getRequesterEmail(key);
		Usuari u = FactoriaControladors.getInstance().getCtrlUsuari().get(correu);
		u.setPass(pass);
		FactoriaControladors.getInstance().getCtrlUsuari().Update(u);
		FactoriaRecuperacio.getInstance().getDipositClaus().removeKey(key);
	}
}
