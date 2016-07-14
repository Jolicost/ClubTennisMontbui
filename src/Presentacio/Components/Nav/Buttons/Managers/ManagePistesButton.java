package Presentacio.Components.Nav.Buttons.Managers;

import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;

public class ManagePistesButton extends ManageEntitatButton {

	public ManagePistesButton() {
		super("Pistes",FactoriaEntitats.getInstance().getPista());
	}

}
