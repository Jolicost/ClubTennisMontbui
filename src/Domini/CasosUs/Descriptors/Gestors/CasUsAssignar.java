package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Controlador.CuaGestors;
import Domini.CasosUs.Resultats.ResultatConjunt;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.Excepcions.CasUsInvalid;

public class CasUsAssignar extends CasUsGestor {


	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		ResultatConjunt r = new ResultatConjunt();
		r.setConjunt(gestor.getAll());
		return r;
	}
	
	public Gestor getChild(Gestor g) throws Exception{
		return g.getIndividualSelector(super.getEntitat());
	}
	
	
	@Override
	protected String getDescriptorGestor() {
		return FactoriaDescriptors.getInstance().getSelect();
	}

}
