package Presentacio.Components.Nav.UserMenu;

import Presentacio.Components.Nav.Buttons.LoginButton;
import Presentacio.Components.Nav.Buttons.SignUpButton;

public class MenuUsuariInvitat extends MenuUsuari{

	@Override
	protected void createComponents() {
		this.AddComponent(new SignUpButton());
		this.AddComponent(new LoginButton());
		
	}
}
