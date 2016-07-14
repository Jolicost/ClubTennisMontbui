package Presentacio.Components.Nav.Main;

import Presentacio.Components.Nav.Buttons.Managers.ManageMenu;

public class MenuAdmin extends MenuRegistrat {

	@Override
	protected void createComponents() {
		super.createComponents();
		super.AddComponent(new ManageMenu());
	}
}
