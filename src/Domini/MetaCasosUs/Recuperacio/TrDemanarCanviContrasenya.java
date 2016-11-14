package Domini.MetaCasosUs.Recuperacio;

import Domini.MetaCasosUs.Recuperacio.Excepcions.UsuariInexistent;
import Factories.FactoriaControladors;
import Mail.Informacio.InformacioMail;
import Mail.Informacio.RecuperarContrasenyaMail;

public class TrDemanarCanviContrasenya {
	
	private String correu;
	
	public TrDemanarCanviContrasenya(String correu){
		this.correu = correu;
	}
	
	public void Executar() throws Exception{
		if (!FactoriaControladors.getInstance().getCtrlUsuari().Exists(correu)) throw new UsuariInexistent();
		String key = FactoriaRecuperacio.getInstance().getDipositClaus().RequestKey(correu);
		InformacioMail mail = new RecuperarContrasenyaMail(correu,key);
		mail.Send();
	}
	
	
}
