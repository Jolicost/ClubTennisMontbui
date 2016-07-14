package Presentacio.TagBuilder;

public class ButtonTag extends ComponentTag {

	public ButtonTag(){
		super.setAttribute("type",getButtonType());
		super.setCls("btn");
		super.appendAttribute("class","btn-default");
	}
	@Override
	protected String getComponentTag() {
		return "button";
	}
	
	protected String getButtonType(){return "button";}

}
