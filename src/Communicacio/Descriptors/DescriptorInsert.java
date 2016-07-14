package Communicacio.Descriptors;

import Communicacio.Xarxa.Domini.Entitats.EntitatInvalida;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.WebComponent;
import Presentacio.Main.PaginaGestor;
import Presentacio.Main.PaginaInsertIndividual;

public class DescriptorInsert extends DescriptorIndividual {

	@Override
	public String getName() {
		return "insert";
	}
	
	public WebComponent getVistaGestor(String entitat) throws EntitatInvalida{
		return FactoriaEntitats.getInstance().getEntitat(entitat).getInsertIndividual();
	}
	
	public WebComponent getPaginaGestor(){
		return new PaginaInsertIndividual();
	}

}
