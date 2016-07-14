package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Controlador.CuaGestors;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatEscriptura;
import Domini.CasosUs.Resultats.ResultatIndividual;

public class CasUsSelect extends CasUsGestorID {


	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		gestor.Select(super.getId());
		
		ResultatEscriptura r = new ResultatEscriptura();
		return r;
	}
	

	@Override
	protected String getDescriptorGestor() {
		return null;
	}


	@Override
	public Gestor getChild(Gestor g) throws Exception {
		return g;
	}

}
