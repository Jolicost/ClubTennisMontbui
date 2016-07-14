package Presentacio.Components.Formularis.Inputs.Pista;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class InputNomCalendari extends TextInput {

	public InputNomCalendari(String initialValue) {
		super("calendari","calendari");
		super.setIsDisabled(true);
		super.setInitialValue(initialValue);
	}
	
	
	@Override
	protected String getLabelName() {
		return "Nom del calendari: ";
	}
}
