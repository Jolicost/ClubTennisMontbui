package Presentacio.Components.Formularis;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.Components.Formularis.Inputs.BotoEnviar;
import Presentacio.TagBuilder.CustomFormTag;

public abstract class Formulari extends MultipleWebComponent {



	
	public Formulari(){
		CustomFormTag t = new CustomFormTag(getDispatcher(),"POST");
		if (HasValidation()) t.setAttribute("data-toggle","validator");
		this.addTag(t);
	}
	
	protected abstract String getDispatcher();

	@Override
	protected void createComponents() {
		createInputs();
		BotoEnviar b = new BotoEnviar(getSubmitName(),"submit");
		super.AddComponent(b);		
	}
	

	
	protected abstract void createInputs();
	protected String getSubmitName(){return "Enviar";}

	@Override
	protected void IncludeMetadata() throws IOException, ServletException {
		if (HasValidation()) super.Append("<script src=\"Components/Misc/Validator.js\"></script>");
	}

	protected boolean HasValidation(){return false;}
	
	

}
