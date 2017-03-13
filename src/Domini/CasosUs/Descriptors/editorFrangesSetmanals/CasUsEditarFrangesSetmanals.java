package Domini.CasosUs.Descriptors.editorFrangesSetmanals;

import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Controladors.FrangesSetmanals.ControladorFrangesSetmanals;
import Domini.CasosUs.Controladors.FrangesSetmanals.IControladorFrangesSetmanals;
import Domini.Excepcions.ActorInvalid;

public class CasUsEditarFrangesSetmanals extends CasUsFrangesSetmanals {

	protected int IDCalendari;
	
	public CasUsEditarFrangesSetmanals(int IDCalendari){
		this.IDCalendari = IDCalendari;
	}


	@Override
	public ControladorCasUs getControladorCasUs() throws ActorInvalid {
		return new ControladorFrangesSetmanals(super.getActor(),IDCalendari);
	}




	@Override
	public void cridarControlador(IControladorFrangesSetmanals c) throws Exception {
		c.getAll();
		//TODO /* Create Result with the table */
	}
}
