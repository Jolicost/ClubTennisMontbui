package Presentacio.TagBuilder;

public class FooterTag extends ComponentTag {

	public FooterTag(){
		super.setAttribute("class", "footer");
	}
	protected String getComponentTag(){
		return "footer";
	};
}
