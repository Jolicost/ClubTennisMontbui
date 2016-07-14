package Presentacio.TagBuilder;

public class CustomFormTag extends FormTag{

	public CustomFormTag(String submit,String method){
		super(submit,method);
		this.setAttribute("role", "form");
	}
}
