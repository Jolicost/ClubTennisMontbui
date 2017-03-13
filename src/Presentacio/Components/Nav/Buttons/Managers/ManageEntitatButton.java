package Presentacio.Components.Nav.Buttons.Managers;

import Presentacio.Components.Nav.MenuItem;

public class ManageEntitatButton extends MenuItem {

	public ManageEntitatButton(String nom,String entitat) {
		super(nom,"gestor?entitat=" + entitat);		
	}

}
