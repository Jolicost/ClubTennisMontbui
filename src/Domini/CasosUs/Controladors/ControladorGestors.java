package Domini.CasosUs.Controladors;

import Communicacio.Excepcions.CapGestor;
import Communicacio.Excepcions.GestorInvalid;
import Domini.Excepcions.CasUsInvalid;

public class ControladorGestors extends ControladorCasUs{



	
	public String getEntitatGestor()throws GestorInvalid, CapGestor, CasUsInvalid{
		return super.casos.peek().toGestor().getEntitat();
	}
	
	

}
