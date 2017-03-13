package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.WebComponent;
import Presentacio.Components.Formularis.Inputs.Usuari.PassInput;
import Presentacio.Components.Formularis.Inputs.Usuari.RangList;

public class FormulariInsertUsuari extends FormulariEditUsuari {

	@Override
	protected void createInputs() {
		
		super.createInputs();
		super.AddComponent(new RangList());
	}
	
	@Override
	protected WebComponent getPassInput() {
		PassInput ret = new PassInput();
		ret.setIsRequired(true);
		return ret;
	}
	
	@Override
	protected String getDispatcher() {
		return "submit";
	}
}
