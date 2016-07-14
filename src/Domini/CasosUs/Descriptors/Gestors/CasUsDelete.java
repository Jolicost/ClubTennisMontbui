package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Controlador.CuaGestors;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatEscriptura;

public class CasUsDelete extends CasUsGestorID {


	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		ResultatEntitat ret = new ResultatEscriptura();
		gestor.Delete(super.getId());
		return ret;
	}

	@Override
	protected String getDescriptorGestor() {
		return FactoriaDescriptors.getInstance().getCRUD();
	}





	@Override
	public Gestor getChild(Gestor g) throws Exception {
		return g;
	}

}
