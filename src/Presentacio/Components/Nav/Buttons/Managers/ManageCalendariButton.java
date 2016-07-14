package Presentacio.Components.Nav.Buttons.Managers;

import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;

public class ManageCalendariButton extends ManageEntitatButton {

	public ManageCalendariButton() {
		super("Calendaris", FactoriaEntitats.getInstance().getCalendari());
	}

}
