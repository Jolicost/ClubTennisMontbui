package Domini.MetaCasosUs.Recuperacio;

import Domini.CasosUs.Controladors.CanviContrasenya.ICasUsRecuperacio;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.CasosUs.Resultats.Generals.ResultatUnicSuccess;

public class CasUsCanviarContrasenya extends CasUsRecuperacio {

	public CasUsCanviarContrasenya(String key){
		this.key = key;		
	}
	private String key;
	@Override
	public boolean IsRoot() {
		return true;
	}

	@Override
	public ResultatCasUs Accio(ICasUsRecuperacio r) throws Exception {
		return r.CanviarContrasenya(key);
	}

}
