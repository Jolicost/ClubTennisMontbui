package Communicacio.Dades.Reserves;

import Communicacio.Xarxa.Domini.Entitats.Ocupacio.FactoriaTipusOcupacio;

public class InfoAltres extends InfoOcupacio {

	public String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getAltres();
	}
}
