package Presentacio.Components.Formularis.Inputs.CalendariOcupacions;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class InputNomCalendariSetmanal extends TextInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputNomCalendariSetmanal(){
		super("nom","nom");
	}

	public InputNomCalendariSetmanal(String nom) {
		super("nom","nom");
		super.setInitialValue(nom);
	}

	@Override
	protected String getLabelName() {
		return "Nom :";
	}
}
