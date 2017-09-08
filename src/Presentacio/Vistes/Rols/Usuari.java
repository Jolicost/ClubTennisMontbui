package Presentacio.Vistes.Rols;

import Presentacio.Components.Nav.Main.MenuPrincipal;
import Presentacio.Components.Nav.Main.MenuRegistrat;
import Presentacio.Components.Nav.UserMenu.MenuUsuari;
import Presentacio.Components.Nav.UserMenu.MenuUsuariRegistrat;

public class Usuari extends Rol {

	@Override
	protected String getRolName() {
		return "usuari";
	}
	
	public MenuUsuari getMenuUsuari(){return new MenuUsuariRegistrat();}
	public MenuPrincipal getMenuPrincipal(){return new MenuRegistrat();}

}
