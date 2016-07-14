package Presentacio.Components.Gestors;

import java.util.ArrayList;
import java.util.List;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.Components.WebComponent;
import Presentacio.TagBuilder.CenteredDesktopColumnTag;
import Presentacio.TagBuilder.RowTag;
import Presentacio.TagBuilder.TagFactory;

public abstract class VistaGestorIndividual extends VistaIndividual{

	@Override
	protected void createComponents() throws Exception {
		List<WebComponent> botons = new ArrayList<>();
		afegirBotons(botons);
		for (WebComponent w: botons) super.AddComponent(w);
		super.AddComponent(getFormulari());
	}
	
	protected abstract WebComponent getFormulari();
	protected void afegirBotons(List<WebComponent> botons){
		
	}

}
