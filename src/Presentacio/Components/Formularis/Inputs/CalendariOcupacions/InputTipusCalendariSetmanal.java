package Presentacio.Components.Formularis.Inputs.CalendariOcupacions;

import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;
import Presentacio.Components.Formularis.Inputs.ListInput;

public class InputTipusCalendariSetmanal extends ListInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputTipusCalendariSetmanal() {
		super("tipus","tipus");
		initValues();
	}

	public InputTipusCalendariSetmanal(String tipus) {
		super("tipus","tipus");
		initValues();
		super.setInitialValue(tipus);
	}

	@Override
	protected String getLabelName() {
		return "Tipus: ";
	}
	
	protected void initValues(){
		FactoriaTipusOcupacio.getInstance().getAll().forEach(t -> super.AddValue(t));
	}

}
