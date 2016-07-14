package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Controlador.CuaGestors;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatIndividual;
import Domini.Excepcions.CasUsInvalid;
import Domini.Model.Rang.FactoriaRangs;

public class CasUsInsert extends CasUsGestor {


	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		return new ResultatEntitat();
	}
	
	public Gestor getChild(Gestor g) throws Exception{
		return g.getIndividualInserter();
	}
	

	@Override
	protected String getDescriptorGestor() {
		return FactoriaDescriptors.getInstance().getInsert();
	}
	

}
