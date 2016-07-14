package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.Formularis.Formulari;
import Presentacio.Components.Formularis.Inputs.Usuari.MailInput;
import Presentacio.Components.Formularis.Inputs.Usuari.PassInput;
import Presentacio.TagBuilder.DesktopColumnTag;

public class FormulariLogin extends Formulari {

	private MailInput m;
	private PassInput p;
	
	

	@Override
	protected String getDispatcher() {
		return "submit_login";
	}

	@Override
	protected void createInputs() {
		m = new MailInput();
		p = new PassInput();
		
		p.setIsRequired(true);
		
		super.AddComponent(m);
		super.AddComponent(p);
	}
	
	protected String getSubmitName(){return "login";}
	
	protected boolean HasValidation(){return false;}
}
