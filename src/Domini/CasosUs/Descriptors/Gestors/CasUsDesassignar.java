package Domini.CasosUs.Descriptors.Gestors;

import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatEscriptura;

public class CasUsDesassignar extends CasUsGestor {


	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		ResultatEntitat ret =  new ResultatEscriptura();
		gestor.Unassign(this.getEntitat());
		return ret;
	}

	@Override
	protected String getDescriptorGestor() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Gestor getChild(Gestor g) throws Exception {
		return g;
	}

}
