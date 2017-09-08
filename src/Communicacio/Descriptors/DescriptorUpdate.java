package Communicacio.Descriptors;

import Communicacio.Xarxa.Domini.Entitats.EntitatInvalida;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.WebComponent;
import Presentacio.Main.PaginaGestorIndividual;

public class DescriptorUpdate extends DescriptorIndividual {

	@Override
	public String getName() {
		return "update";
	}
	
	public WebComponent getVistaGestor(String entitat) throws EntitatInvalida{
		return FactoriaEntitats.getInstance().getEntitat(entitat).getGestorIndividual();
	}
	
	public WebComponent getPaginaGestor(){
		return new PaginaGestorIndividual();
	}

}
