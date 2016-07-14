package Domini.CasosUs.Descriptors.Gestors;

import java.io.Serializable;

import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Obertures.GestorAfegirObertures;
import Domini.CasosUs.Resultats.ResultatAfegirObertures;
import Domini.CasosUs.Resultats.ResultatEntitat;

public class CasUsAfegirObertures extends CasUsGestor {

	
	
	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		ResultatAfegirObertures ret = new ResultatAfegirObertures();
		return ret;
	}
	
	public Gestor getChild(Gestor g) throws Exception{
		Serializable idCal = g.toGestorIndividual().getKey();
		Gestor ret = new GestorAfegirObertures(Integer.valueOf(idCal.toString()));
		return ret;
	}
	
	@Override
	protected String getDescriptorGestor() {
		return null;
	}

}
