package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Controlador.CuaGestors;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatIndividual;
import Domini.Excepcions.CasUsInvalid;

public class CasUsUpdate extends CasUsGestorID {



	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		ResultatIndividual r = new ResultatIndividual(gestor.Get());
		return r;
	}


	@Override
	public Gestor getChild(Gestor g) throws Exception {
		return g.getIndividualUpdater(super.getId());
	}

	@Override
	protected String getDescriptorGestor() {
		return FactoriaDescriptors.getInstance().getUpdate();
	}
}
