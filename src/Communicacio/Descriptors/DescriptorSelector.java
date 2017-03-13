package Communicacio.Descriptors;

import Communicacio.Xarxa.Domini.Entitats.EntitatInvalida;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.WebComponent;
import Presentacio.Main.PaginaSelector;

public class DescriptorSelector extends DescriptorColectiu {

	@Override
	public String getName() {
		return "select";
	}
	
	public WebComponent getVistaGestor(String entitat) throws EntitatInvalida{
		return FactoriaEntitats.getInstance().getEntitat(entitat).getSelectorEntitat();
	}
	
	public WebComponent getPaginaGestor(){
		return new PaginaSelector();
	}

}
