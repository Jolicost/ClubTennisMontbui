package Presentacio.Components.Nav;

import Presentacio.Components.SingleWebComponent;
import Presentacio.TagBuilder.NavBarMenuItem;

public abstract class NavBarItem extends SingleWebComponent{

	public NavBarItem(){
		super();
		super.addTag(new NavBarMenuItem());
	}
}
