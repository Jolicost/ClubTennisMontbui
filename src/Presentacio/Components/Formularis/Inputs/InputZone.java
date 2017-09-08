package Presentacio.Components.Formularis.Inputs;

import Presentacio.Components.SingleWebComponent;
import Presentacio.TagBuilder.CustomTag;

public abstract class InputZone extends SingleWebComponent {

	private String type;
	private String id;
	private String name;
	protected String initValue;
	private boolean IsRequired;
	private boolean IsDisabled;
	
	
	public InputZone(){

	}
	
	@Override
	public void InitContent() {
		super.InitContent();
		CustomTag t = new CustomTag();
		
		if (type != null) t.setAttribute("type", type);
		if (id != null) t.setAttribute("id", id);
		if (name != null) t.setAttribute("name", name);
		if (initValue != null) t.setAttribute("value", initValue);
		if (IsRequired()) t.setAttribute("required","true");
		
		t.setAttribute("class", "form-control");
		t.setTagName(getTagType());
		
		if (IsDisabled) t.setAttribute("disabled","true");
		
		super.addTag(t);
	}
	
	protected abstract String getTagType();

	
	protected boolean IsRequired(){return IsRequired;}

	public void setType(String type) {
		this.type = type;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInitValue(String initValue) {
		this.initValue = initValue;
	}

	public void setIsRequired(boolean isRequired) {
		IsRequired = isRequired;
	}

	public void setIsDisabled(boolean isDisabled) {
		IsDisabled = isDisabled;
	}
	
	

}
