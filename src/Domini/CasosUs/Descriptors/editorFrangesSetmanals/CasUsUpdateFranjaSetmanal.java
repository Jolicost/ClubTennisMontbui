package Domini.CasosUs.Descriptors.editorFrangesSetmanals;

import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoFranjaSetmanal;
import Domini.CasosUs.Controladors.FrangesSetmanals.IControladorFrangesSetmanals;
import Domini.CasosUs.Resultats.FrangesSetmanals.ResultatUpdateFranja;

public class CasUsUpdateFranjaSetmanal extends CasUsFrangesSetmanals {

	protected InfoFranjaSetmanal i;
	public CasUsUpdateFranjaSetmanal(InfoFranjaSetmanal i){
		this.i = i;
	}

	@Override
	public void cridarControlador(IControladorFrangesSetmanals c) throws Exception {
		c.Update(this.i);
		super.resultat = new ResultatUpdateFranja(c.getAll());
		
	}

}
