package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class AdrecaInput extends TextInput {

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
