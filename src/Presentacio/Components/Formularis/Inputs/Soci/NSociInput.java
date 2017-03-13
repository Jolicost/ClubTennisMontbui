package Presentacio.Components.Formularis.Inputs.Soci;

import Presentacio.Components.Formularis.Inputs.TextInput;

public abstract class NSociInput extends TextInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NSociInput(){
		super();
		super.setName(getInputName());
		super.setId(getInputName());
	}
	public NSociInput(String nsoci) {
		super();
		super.setName(getInputName());
		super.setId(getInputName());
		super.setInitialValue(nsoci);
	}
	@Override
	protected String getLabelName() {
		return "Numero de Soci: ";
	}
	
	
	protected abstract String getInputName();
	protected String getInputType(){return "number";}

}
