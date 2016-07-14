package Presentacio.Components.Formularis.Inputs;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;

import Presentacio.Components.Formularis.ErrorTxt;
import Presentacio.TagBuilder.CustomTag;
import Presentacio.TagBuilder.DesktopColumnTag;

public abstract class LabelInput extends Input implements Serializable {


	protected String initialValue;
	protected String type;
	protected String label;
	protected String id;
	protected String name;
	protected boolean IsDisabled;
	protected boolean IsRequired;
	
	
	protected LabelZone l;
	protected InputZone i;
	
	public LabelInput(){

	}
	
	@Override
	protected void createComponents() {
		CustomTag t = new CustomTag();
		t.setCls("form-group");
		super.addTag(t);
		
		l = getLabel();
		super.AddComponent(l);
		
		i = getInputZone();
		super.AddComponent(i);
		
		super.AddComponent(new ErrorTxt());
		
		l.setForid(id);
		l.setLabel(label);
		
		i.setType(type);
		i.setId(id);
		i.setInitValue(initialValue);
		i.setIsDisabled(IsDisabled);
		i.setIsRequired(IsRequired);
		i.setName(name);
	}
	

	public void setType(String type) {
		this.type = type;
	}

	protected abstract InputZone getInputZone();	
	protected LabelZone getLabel(){return new LabelZone();}

	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsDisabled(boolean isDisabled) {
		IsDisabled = isDisabled;
	}

	public void setIsRequired(boolean isRequired) {
		IsRequired = isRequired;
	}

	


}
