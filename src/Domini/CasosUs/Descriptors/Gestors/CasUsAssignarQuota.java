package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Controladors.Quotes.ControladorSeleccionarQuota;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.Generals.ResultatTriarQuota;

public class CasUsAssignarQuota extends CasUsAssignar {

	private ControladorSeleccionarQuota q;
	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		return new ResultatTriarQuota();
	}
	
	public Gestor getChild(Gestor g) throws Exception{
		q = new ControladorSeleccionarQuota(Integer.valueOf(g.toGestorIndividual().getKey().toString()));
		return q;
	}
	
	
	@Override
	protected String getDescriptorGestor() {
		return FactoriaDescriptors.getInstance().getSelect();
	}
	
}
