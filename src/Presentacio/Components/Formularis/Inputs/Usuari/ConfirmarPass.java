package Presentacio.Components.Formularis.Inputs.Usuari;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.TagBuilder.NullTag;

public class ConfirmarPass extends MultipleWebComponent {

	private PassInput input;
	private PassInput confirm;
	
	public ConfirmarPass(){
		
	}
	@Override
	protected void createComponents() {
		input = new PassInput();
		input.setIsRequired(true);
		confirm = new ConfirmPassInput("cpass","cpass","pass");
		
		super.AddComponent(input);
		super.AddComponent(confirm);
	}
	

	
	
}
