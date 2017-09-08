package Domini.CasosUs.Descriptors.editorFrangesSetmanals;

import java.util.Set;

import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoFranjaSetmanal;
import Domini.CasosUs.Controladors.FrangesSetmanals.IControladorFrangesSetmanals;
import Domini.CasosUs.Resultats.FrangesSetmanals.ResultatUpdateFranja;

public class CasUsEliminarFrangesSetmanals extends CasUsFrangesSetmanals {

	protected Set<Integer> ids;
	public CasUsEliminarFrangesSetmanals(Set<Integer> ids){
		this.ids = ids;
	}

	@Override
	public void cridarControlador(IControladorFrangesSetmanals c) throws Exception {
		c.Delete(ids);
		super.resultat = new ResultatUpdateFranja(c.getAll());
	}

}
