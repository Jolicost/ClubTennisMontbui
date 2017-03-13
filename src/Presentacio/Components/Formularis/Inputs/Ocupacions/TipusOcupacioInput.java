package Presentacio.Components.Formularis.Inputs.Ocupacions;

import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;
import Presentacio.Components.Formularis.Inputs.ListInput;

public class TipusOcupacioInput extends ListInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TipusOcupacioInput() {
		super("tipus","tipus");
		for (String s:FactoriaTipusOcupacio.getInstance().getAll()){
			super.AddValue(s);
		}
	}
	
	public TipusOcupacioInput(String initValue) {
		super("tipus","tipus");
		for (String s:FactoriaTipusOcupacio.getInstance().getAll()){
			super.AddValue(s);
		}
		super.setInitialValue(initValue);
	}

}
