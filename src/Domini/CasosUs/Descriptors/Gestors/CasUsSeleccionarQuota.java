package Domini.CasosUs.Descriptors.Gestors;

import Domini.CasosUs.Controladors.Quotes.ControladorSeleccionarQuota;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Resultats.ResultatEntitat;

public class CasUsSeleccionarQuota extends CasUsSelect{

	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		ControladorSeleccionarQuota c = (ControladorSeleccionarQuota) super.gestor;
		return c.SeleccionarQuota(super.id.toString());	
	}
	
	public Gestor getChild(Gestor g) throws Exception{
		return g;
	}
	
	public void ferCasUs() throws Exception{
		ResultatEntitat r = RealitzarCasUs();
		this.setResultat(r);
	}

	@Override
	protected String getDescriptorGestor() {
		// TODO Auto-generated method stub
		return null;
	}

}
