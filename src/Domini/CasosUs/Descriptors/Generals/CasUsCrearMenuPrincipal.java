package Domini.CasosUs.Descriptors.Generals;

import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.Accions.ResultatAccionsPrincipals;

public class CasUsCrearMenuPrincipal extends CasUs{

	@Override
	public void ferCasUs() throws Exception {
		ResultatAccionsPrincipals ret = new ResultatAccionsPrincipals(super.getActor().getInfoAccions(),super.getActor().getInfoAccionsUsuari());
		super.setResultat(ret);		
	}

}
