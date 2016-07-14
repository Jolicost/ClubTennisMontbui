package Presentacio.Components.Formularis.Inputs.Pista;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class InputNomPista extends TextInput {

	@Override
	protected String getLabelName() {
		return "Nom: ";
	}
	
	public InputNomPista() {
		super("nom","nom");
	}
	
	public InputNomPista(String initialValue) {
		super("nom","nom");
		super.setInitialValue(initialValue);
	}

}
