package Presentacio.Components.Nav.Buttons.Managers;

import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.Nav.MenuItem;

public class ManageUsersButton extends ManageEntitatButton{

	public ManageUsersButton() {
		super("Usuaris",FactoriaEntitats.getInstance().getUsuari());
	}

	
}
