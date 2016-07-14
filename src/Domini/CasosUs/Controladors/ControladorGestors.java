package Domini.CasosUs.Controladors;

import Communicacio.Excepcions.CapGestor;
import Communicacio.Excepcions.GestorInvalid;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Descriptors.Gestors.CasUsGestor;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Controlador.CuaGestors;
import Domini.Excepcions.CasUsInvalid;

public class ControladorGestors extends ControladorCasUs{



	
	public String getEntitatGestor()throws GestorInvalid, CapGestor, CasUsInvalid{
		return super.casos.peek().toGestor().getEntitat();
	}
	
	

}
