package Communicacio.Descriptors;

import Communicacio.Xarxa.Domini.Entitats.EntitatInvalida;
import Presentacio.Components.EmptyComponent;
import Presentacio.Components.WebComponent;
import Presentacio.Main.PaginaHome;

public abstract class DescriptorGestor {

	public abstract String getName();
	
	public WebComponent getVistaGestor(String entitat) throws EntitatInvalida{
		return new EmptyComponent();
	}
	
	public WebComponent getPaginaGestor(){
		return new PaginaHome();
	}
}
