package Domini.MetaCasosUs.Recuperacio;

import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Controladors.CanviContrasenya.ControladorCanviContrasenya;
import Domini.CasosUs.Controladors.CanviContrasenya.ICasUsRecuperacio;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.Excepcions.ActorInvalid;
import Domini.Excepcions.CasUsInvalid;

public abstract class CasUsRecuperacio extends CasUs{

	public CasUsRecuperacio toRecuperacio() throws CasUsInvalid{
		return this;
	}
	
	public abstract ResultatCasUs Accio(ICasUsRecuperacio r) throws Exception;

	@Override
	public ControladorCasUs getControladorCasUs() throws ActorInvalid {
		return new ControladorCanviContrasenya();
	}
}
