package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.WebComponent;
import Presentacio.Components.Formularis.Formulari;
import Presentacio.Components.Formularis.Inputs.Soci.DniInput;
import Presentacio.Components.Formularis.Inputs.Soci.NameInput;
import Presentacio.Components.Formularis.Inputs.Soci.SurnamesInput;
import Presentacio.Components.Formularis.Inputs.Usuari.MailInput;

public abstract class FormulariUsuari extends Formulari {

	@Override
	protected String getDispatcher() {
		return "submit";
	}

	@Override
	protected void createInputs() {
		super.AddComponent(getMailInput());
		super.AddComponent(getNameInput());
		super.AddComponent(getSurnamesInput());
		super.AddComponent(getDniInput());
		this.AddComponent(getPassInput());
		
	}
	
	protected abstract WebComponent getPassInput(); 
	protected String getSubmitName(){return super.getSubmitName();}
	
	protected MailInput getMailInput(){return new MailInput();}
	protected NameInput getNameInput(){
		NameInput ret = new NameInput();
		ret.setIsRequired(true);
		return ret;
	}
	protected SurnamesInput getSurnamesInput(){
		SurnamesInput ret = new SurnamesInput();
		ret.setIsRequired(true);
		return ret;
	}
	protected DniInput getDniInput(){return new DniInput();}
	
}
