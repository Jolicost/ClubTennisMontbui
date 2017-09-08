package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class AdrecaInput extends TextInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdrecaInput() {
		super("adreca","adreca");
		
	}
	
	public AdrecaInput(String adreca) {
		super("adreca","adreca");
		super.setInitialValue(adreca);
	}

	protected String getLabelName(){
		return "Adreça: ";
	}
}
