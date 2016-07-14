package Presentacio.Vistes.Rols;

import Presentacio.Components.Nav.Main.MenuAdmin;
import Presentacio.Components.Nav.Main.MenuInvitat;
import Presentacio.Components.Nav.Main.MenuPrincipal;
import Presentacio.Components.Nav.UserMenu.MenuUsuari;
import Presentacio.Components.Nav.UserMenu.MenuUsuariInvitat;

public abstract class Rol {

	
	public boolean Matches(String rolName){
		if (rolName.equals(getRolName())) return true;
		else return false;
	}
	protected abstract String getRolName();
	
	
	public MenuUsuari getMenuUsuari(){return new MenuUsuariInvitat();}
	public MenuPrincipal getMenuPrincipal(){
		return new MenuInvitat();
	}
}
