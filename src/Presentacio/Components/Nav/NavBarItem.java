package Presentacio.Components.Nav;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.Components.SingleWebComponent;
import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.NavBarMenuItem;

public abstract class NavBarItem extends SingleWebComponent{

	public NavBarItem(){
		super();
		super.addTag(new NavBarMenuItem());
	}
}
