package Presentacio.Components.Nav;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.TagBuilder.NavBarMenu;

public abstract class Menu extends MultipleWebComponent {

	public Menu(){
		super();
		this.addTag(new NavBarMenu());
	}

	
	

}
