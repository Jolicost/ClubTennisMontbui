package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Resultats.ResultatConjunt;
import Domini.CasosUs.Resultats.ResultatEntitat;

public class CasUsSubGestor extends CasUsGestor{



	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		ResultatConjunt ret = new ResultatConjunt();
		ret.setConjunt(gestor.getAll());
		return ret;
	}
	
	public Gestor getChild(Gestor g) throws Exception{
		return g.getCollectionManager(super.getEntitat());
	}
	
	public boolean IsNeutral(){
		return true;
	}


	@Override
	protected String getDescriptorGestor() {
		return FactoriaDescriptors.getInstance().getCRUD();
	}

}
