package Presentacio.Components.Nav.UserMenu;

import Presentacio.Components.Nav.Buttons.LogoutButton;
import Presentacio.Components.Nav.Buttons.ProfileButton;

public class MenuUsuariRegistrat extends MenuUsuari {

	public MenuUsuariRegistrat(){
		super();
	}
	
	@Override
	protected void createComponents() {
		this.AddComponent(new ProfileButton());
		this.AddComponent(new LogoutButton());
		
	}
}
