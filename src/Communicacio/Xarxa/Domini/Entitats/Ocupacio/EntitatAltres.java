package Communicacio.Xarxa.Domini.Entitats.Ocupacio;

import Communicacio.Dades.Reserves.InfoAltres;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Domini.Model.Reserves.Altres;
import Domini.Model.Reserves.Ocupacio;

public class EntitatAltres extends EntitatTipusOcupacio {

	@Override
	public String getNom() {
		return "altres";
	}

	@Override
	public Ocupacio getTipusOcupacio() {
		return new Altres();
	}

	@Override
	public InfoOcupacio getInfoOcupacio() {
		return new InfoAltres();
	}

}
