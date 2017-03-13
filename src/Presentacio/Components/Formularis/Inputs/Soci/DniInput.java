package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class DniInput extends TextInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DniInput() {
		super("dni","dni");
		super.setIsRequired(true);
	}
	
	public DniInput(String dni) {
		super("dni","dni");
		super.setIsRequired(true);
		super.setInitialValue(dni);
	}

	protected String getLabelName(){
		return "Dni: ";
	}

	

}
