package Presentacio.Components.Gestors.Soci;

import java.util.List;

import Communicacio.Dades.Info;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.TagBuilder.RowTag;

public class VistaUpdateSoci extends VistaGestorIndividual {



	protected void afegirBotons(List<WebComponent> botons){
		botons.add(new BotoAssignarQuota());
	}
	@Override
	protected WebComponent getFormulari() {
		Info i = (Info) super.io.getParam("individual");
		return new FormulariSociUpdate(i);
	}
}