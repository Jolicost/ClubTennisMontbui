package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Formularis.Inputs.Soci.DniInput;
import Presentacio.Components.Formularis.Inputs.Soci.NameInput;
import Presentacio.Components.Formularis.Inputs.Soci.SurnamesInput;
import Presentacio.Components.Formularis.Inputs.Usuari.ConfirmarPass;
import Presentacio.Components.Formularis.Inputs.Usuari.MailInput;
import Presentacio.TagBuilder.DesktopColumnTag;

public class FormulariRegistre extends FormulariUsuari {



	
	protected boolean HasValidation(){return true;}
	
	protected String getSubmitName(){return "registre";}

	@Override
	protected WebComponent getPassInput() {
		return new ConfirmarPass();
	}

}
