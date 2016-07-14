package Presentacio.Components.Nav.Buttons.Managers;

import Presentacio.Components.Nav.DropdownMenu;

public  class ManageMenu extends DropdownMenu {

	public ManageMenu() {
		super("Administrar");
		super.AddItem(new ManageUsersButton());
		super.AddItem(new ManageSocisButton());
		super.AddItem(new ManagePistesButton());
		super.AddItem(new ManageCalendariButton());
	}


}
