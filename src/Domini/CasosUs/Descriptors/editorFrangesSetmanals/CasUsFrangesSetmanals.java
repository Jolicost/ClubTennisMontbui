package Domini.CasosUs.Descriptors.editorFrangesSetmanals;

import Domini.CasosUs.Controladors.FrangesSetmanals.IControladorFrangesSetmanals;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.Excepcions.CasUsInvalid;

public abstract class CasUsFrangesSetmanals extends CasUs{
	public CasUsFrangesSetmanals toFrangesSetmanals() throws CasUsInvalid{
		return this;
	}
	
	public abstract void cridarControlador(IControladorFrangesSetmanals c) throws Exception;

}
