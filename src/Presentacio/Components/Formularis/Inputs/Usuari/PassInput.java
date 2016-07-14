package Presentacio.Components.Formularis.Inputs.Usuari;

import Presentacio.Components.Formularis.Inputs.TextInput;

public class PassInput extends TextInput {

	public PassInput() {
		super("password","pass");
	}
	
	public PassInput(String id,String name){
		super(id,name);
	}

	
	protected String getLabelName(){return "Password: ";}
	protected String getInputType(){return "password";}

}
