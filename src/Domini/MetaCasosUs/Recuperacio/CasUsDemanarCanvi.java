package Domini.MetaCasosUs.Recuperacio;

import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.Generals.ResultatUnicSuccess;

public class CasUsDemanarCanvi extends CasUs {

	private String correu;
	public CasUsDemanarCanvi(String correu){
		this.correu = correu;
	}
	@Override
	public boolean IsRoot() {
		return true;
	}

	@Override
	public void ferCasUs() throws Exception {
		new TrDemanarCanviContrasenya(correu).Executar();
		super.setResultat(new ResultatUnicSuccess("S'ha enviat un correu de recuperació al e-mail indicat"));
	}

}
