package Presentacio.TagBuilder;

public class NavBarMenu extends ComponentTag {

	public NavBarMenu(){
		super.setAttribute("class","nav navbar-nav");
	}
	
	protected String getComponentTag(){
		return "ul";
	};
}
