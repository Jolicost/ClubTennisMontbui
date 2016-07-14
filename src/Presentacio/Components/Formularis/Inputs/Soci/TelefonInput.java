package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class TelefonInput extends TextInput {
	
	public TelefonInput() {
		super("telefon","telefon");
		
	}
	
	public TelefonInput(String tlf) {
		super("telefon","telefon");
		super.setInitialValue(tlf);
	}

	protected String getLabelName(){
		return "Telefon: ";
	}
}
