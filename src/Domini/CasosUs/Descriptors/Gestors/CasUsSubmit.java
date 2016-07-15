package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Controlador.CuaGestors;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatEscriptura;
import Domini.Model.Rang.FactoriaRangs;

public class CasUsSubmit extends CasUsGestor {



	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		gestor.Submit(super.getDada());
		return new ResultatEscriptura();
	}
	

	@Override
	public Gestor getChild(Gestor g) throws Exception {
		return g;
	}


	@Override
	protected String getDescriptorGestor() {
		return null;
	}
	
	public int getRang(){
		return FactoriaRangs.getInstance().getNormal().getPermis();
	}
	


}
