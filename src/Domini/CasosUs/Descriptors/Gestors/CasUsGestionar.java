package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Descriptors.FactoriaDescriptors;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Controladors.ControladorGestors;
import Domini.CasosUs.Resultats.ResultatConjunt;
import Domini.CasosUs.Resultats.ResultatEntitat;

public class CasUsGestionar extends CasUsGestor {

	
	public ControladorCasUs getControladorCasUs(){
		return new ControladorGestors();
	}
	
	public boolean IsRoot(){
		return true;
	}
	
	public boolean IsNeutral(){
		return true;
	}


	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		gestor = FactoriaEntitats.getInstance().getEntitat(super.getEntitat()).getGestor();
		ResultatConjunt ret = new ResultatConjunt();
		ret.setConjunt(gestor.getAll());
		return ret;
	}

	@Override
	protected String getDescriptorGestor() {
		return FactoriaDescriptors.getInstance().getCRUD();
	}
}
