package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.Temporals.DateInput;

public class NaixamentInput extends DateInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaixamentInput() {
		super("naixament","naixament");
		
	}
	
	public NaixamentInput(String naixament) {
		super("naixament","naixament");
		super.setInitialValue(naixament);
	}

	protected String getLabelName(){
		return "Naixament: ";
	}
}

