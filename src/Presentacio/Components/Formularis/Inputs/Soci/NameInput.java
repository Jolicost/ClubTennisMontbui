package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class NameInput extends TextInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
