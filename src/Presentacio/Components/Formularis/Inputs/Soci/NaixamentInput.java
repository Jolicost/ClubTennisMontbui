package Presentacio.Components.Formularis.Inputs.Soci;

import org.joda.time.LocalDate;

import Presentacio.Components.Formularis.Inputs.Temporals.DateInput;

public class NaixamentInput extends DateInput {

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

