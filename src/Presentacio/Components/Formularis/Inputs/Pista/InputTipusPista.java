package Presentacio.Components.Formularis.Inputs.Pista;

import Communicacio.Xarxa.Domini.Entitats.Pista.FactoriaTipusPista;
import Presentacio.Components.Formularis.Inputs.ListInput;

public class InputTipusPista extends ListInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputTipusPista() {
		super("tipus","tipus");
		AddValues();
	}
	
	public InputTipusPista(String initialValue) {
		super("tipus","tipus");
		super.setInitialValue(initialValue);
		AddValues();
	}
	
	private void AddValues(){
		FactoriaTipusPista.getInstance().getAllTipus().forEach(t -> super.AddValue(t));
	}

	@Override
	protected String getLabelName() {
		return "Tipus de Pista: ";
	}

}
