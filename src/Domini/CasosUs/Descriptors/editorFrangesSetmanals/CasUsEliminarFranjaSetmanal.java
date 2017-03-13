package Domini.CasosUs.Descriptors.editorFrangesSetmanals;

import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoFranjaSetmanal;
import Domini.CasosUs.Controladors.FrangesSetmanals.IControladorFrangesSetmanals;

public class CasUsEliminarFranjaSetmanal extends CasUsFrangesSetmanals {

	protected int id;
	public CasUsEliminarFranjaSetmanal(int id){
		this.id = id;
	}

	@Override
	public void cridarControlador(IControladorFrangesSetmanals c) throws Exception {
		c.Delete(this.id);
		//TODO /* Create Result and populate */
		
	}

}
