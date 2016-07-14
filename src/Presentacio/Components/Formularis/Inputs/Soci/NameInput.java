package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class NameInput extends TextInput{

	public NameInput() {
		super("nom","nom");
		
	}
	
	public NameInput(String name) {
		super("nom","nom");
		super.setInitialValue(name);
	}

	protected String getLabelName(){
		return "Nom: ";
	}

}
