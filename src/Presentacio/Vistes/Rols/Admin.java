package Presentacio.Vistes.Rols;

import Presentacio.Components.Nav.Main.MenuAdmin;
import Presentacio.Components.Nav.Main.MenuPrincipal;

public class Admin extends Soci {

	@Override
	protected String getRolName() {
		return "admin";
	}
	
	public MenuPrincipal getMenuPrincipal(){return new MenuAdmin();}
}
