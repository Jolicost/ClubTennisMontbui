package Presentacio.Components.Gestors;

import java.util.ArrayList;
import java.util.List;

import Presentacio.Components.WebComponent;

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
