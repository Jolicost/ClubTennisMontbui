package Domini.CasosUs.Descriptors.editorFrangesSetmanals;

import java.util.Set;

import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoFranjaSetmanal;
import Domini.CasosUs.Controladors.FrangesSetmanals.IControladorFrangesSetmanals;
import Domini.CasosUs.Resultats.FrangesSetmanals.ResultatInsertarFranja;

public class CasUsInsertarFranjaSetmanal extends CasUsFrangesSetmanals {

	protected InfoDiaSetmana i;
	public CasUsInsertarFranjaSetmanal(InfoDiaSetmana i){
		this.i = i;
	}

	@Override
	public void cridarControlador(IControladorFrangesSetmanals c) throws Exception {
		
		c.Insert(this.i);
		Set<InfoFranjaSetmanal> taula = c.getAll();
		ResultatInsertarFranja ret = new ResultatInsertarFranja(taula);
		super.setResultat(ret);
	}

}
