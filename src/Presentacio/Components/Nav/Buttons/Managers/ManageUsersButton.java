package Presentacio.Components.Nav.Buttons.Managers;

import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;

public class ManageUsersButton extends ManageEntitatButton{

	public ManageUsersButton() {
		super("Usuaris",FactoriaEntitats.getInstance().getUsuari());
	}

	
}
