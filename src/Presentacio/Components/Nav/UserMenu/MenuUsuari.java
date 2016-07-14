package Presentacio.Components.Nav.UserMenu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.Components.Nav.Menu;
import Presentacio.Components.Nav.Buttons.LoginButton;
import Presentacio.Components.Nav.Buttons.SignUpButton;

public abstract class MenuUsuari extends Menu {

	public MenuUsuari(){
		super();
		this.getFirstTag().appendAttribute("class", "navbar-right");
	}

	

}
