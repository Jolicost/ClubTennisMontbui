package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.WebComponent;
import Presentacio.Components.Formularis.Inputs.Usuari.ConfirmarPass;

public class FormulariRegistre extends FormulariUsuari {



	
	protected boolean HasValidation(){return true;}
	
	protected String getSubmitName(){return "registre";}

	@Override
	protected WebComponent getPassInput() {
		return new ConfirmarPass();
	}

}
