package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class SurnamesInput extends TextInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public SurnamesInput() {
		super("cognoms","cognoms");
	}
	
	public SurnamesInput(String surnames) {
		super("cognoms","cognoms");
		super.setInitialValue(surnames);
	}

	
	protected String getLabelName(){
		return "Cognoms: ";
	}

}
