package Domini.MetaCasosUs.Recuperacio;

import Domini.CasosUs.Controladors.CanviContrasenya.ICasUsRecuperacio;
import Domini.CasosUs.Resultats.ResultatCasUs;

public class CasUsSubmitPass extends CasUsRecuperacio {

	private String pass;
	public CasUsSubmitPass(String pass){
		this.pass = pass;
	}
	@Override
	public ResultatCasUs Accio(ICasUsRecuperacio r) throws Exception {
		return r.Submit(pass);
	}
	
	

}
