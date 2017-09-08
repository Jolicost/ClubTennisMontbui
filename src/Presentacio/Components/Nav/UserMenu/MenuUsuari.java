package Presentacio.Components.Nav.UserMenu;

import Presentacio.Components.Nav.Menu;

public abstract class MenuUsuari extends Menu {

	public MenuUsuari(){
		super();
		this.getFirstTag().appendAttribute("class", "navbar-right");
	}

	

}
