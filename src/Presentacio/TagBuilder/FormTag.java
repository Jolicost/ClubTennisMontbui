package Presentacio.TagBuilder;

public class FormTag extends ComponentTag {

	public FormTag(String submit,String method){
		this.setCls("form");
		this.appendAttribute("action", submit);
		this.appendAttribute("method", method);
	}
	@Override
	protected String getComponentTag() {
		return "form";
	}


	
}
