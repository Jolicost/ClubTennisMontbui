package Presentacio.Components.Formularis.Inputs.Ocupacions;

import Communicacio.Xarxa.Domini.Entitats.Ocupacio.FactoriaTipusOcupacio;
import Presentacio.Components.Formularis.Inputs.ListInput;

public class TipusOcupacioInput extends ListInput {

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
