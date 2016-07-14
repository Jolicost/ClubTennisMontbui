package Domini.CasosUs.Descriptors.Gestors;

import java.io.Serializable;

import Communicacio.Xarxa.Domini.Entitats.Ocupacio.FactoriaTipusOcupacio;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Franges.GestorAfegirOcupacions;
import Domini.CasosUs.Resultats.ResultatAfegirObertures;
import Domini.CasosUs.Resultats.ResultatAfegirOcupacions;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.Model.Rang.FactoriaRangs;

public class CasUsAfegirOcupacions extends CasUsGestor {

	
	
	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		ResultatAfegirOcupacions ret = new ResultatAfegirOcupacions(FactoriaTipusOcupacio.getInstance().getAll());
		return ret;
	}
	
	public Gestor getChild(Gestor g) throws Exception{
		Serializable idPista = g.toGestorIndividual().getKey();
		Gestor ret = new GestorAfegirOcupacions(Integer.valueOf(idPista.toString()));
		return ret;
	}
	
	@Override
	protected String getDescriptorGestor() {
		return null;
	}


}
