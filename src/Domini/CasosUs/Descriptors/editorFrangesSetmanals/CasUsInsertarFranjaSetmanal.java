package Domini.CasosUs.Descriptors.editorFrangesSetmanals;

import java.util.Set;

import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoFranjaSetmanal;
import Domini.CasosUs.Controladors.FrangesSetmanals.IControladorFrangesSetmanals;

public class CasUsInsertarFranjaSetmanal extends CasUsFrangesSetmanals {

	protected InfoDiaSetmana i;
	public CasUsInsertarFranjaSetmanal(InfoDiaSetmana i){
		this.i = i;
	}

	@Override
	public void cridarControlador(IControladorFrangesSetmanals c) throws Exception {
		
		c.Insert(this.i);
		Set<InfoFranjaSetmanal> taula = c.getAll();
		//TODO /* Create Result and populate */
		
	}

}
