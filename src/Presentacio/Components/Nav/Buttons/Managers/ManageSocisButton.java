package Presentacio.Components.Nav.Buttons.Managers;

import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;

public class ManageSocisButton extends ManageEntitatButton {

	public ManageSocisButton() {
		super("Socis", FactoriaEntitats.getInstance().getSoci());
	}

}
