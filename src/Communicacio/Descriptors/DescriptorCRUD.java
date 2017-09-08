package Communicacio.Descriptors;

import Communicacio.Xarxa.Domini.Entitats.EntitatInvalida;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.WebComponent;
import Presentacio.Main.PaginaGestor;

public class DescriptorCRUD extends DescriptorColectiu {
	@Override
	public String getName() {
		return "crud"; 
	}
	
	public WebComponent getVistaGestor(String entitat) throws EntitatInvalida{
		return FactoriaEntitats.getInstance().getEntitat(entitat).getGestorEntitat();
	}
	
	public WebComponent getPaginaGestor(){
		return new PaginaGestor();
	}
}
