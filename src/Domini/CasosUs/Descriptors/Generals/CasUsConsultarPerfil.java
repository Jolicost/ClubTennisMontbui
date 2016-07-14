package Domini.CasosUs.Descriptors.Generals;

import Domini.CasosUs.Actors.Registrat;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.ResultatIndividual;
import Domini.Model.Usuari;
import Factories.FactoriaControladors;

public class CasUsConsultarPerfil extends CasUs {

	@Override
	public void ferCasUs() throws Exception {
		Registrat r = super.getActor().getRegistrat();
		Usuari u = FactoriaControladors.getInstance().getCtrlUsuari().get(r.getCorreu());
		super.resultat = new ResultatIndividual(u.toInfo());	
	}

}
