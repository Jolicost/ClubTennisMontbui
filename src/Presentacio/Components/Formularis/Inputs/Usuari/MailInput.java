package Presentacio.Components.Formularis.Inputs.Usuari;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class MailInput extends TextInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MailInput(String initValue) {
		super("email","email");
		super.setInitialValue(initValue);
		super.setIsRequired(true);
		
	}
	
	public MailInput(){
		super("email","email");
		super.setIsRequired(true);
	}

	protected String getInputType(){return "email";}
	@Override
	protected String getLabelName() {
		return "Email: ";
	}
}
