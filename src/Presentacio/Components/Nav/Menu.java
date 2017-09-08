package Presentacio.Components.Nav;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.TagBuilder.NavBarMenu;

public abstract class Menu extends MultipleWebComponent {

	public Menu(){
		super();
		this.addTag(new NavBarMenu());
	}

	
	

}
