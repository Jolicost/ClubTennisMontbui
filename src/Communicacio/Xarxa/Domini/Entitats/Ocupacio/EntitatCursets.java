package Communicacio.Xarxa.Domini.Entitats.Ocupacio;

import Communicacio.Dades.Reserves.InfoCursets;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Domini.Model.Reserves.Cursets;
import Domini.Model.Reserves.Ocupacio;

public class EntitatCursets extends EntitatTipusOcupacio {

	@Override
	public String getNom() {
		return "cursets";
	}

	@Override
	public Ocupacio getTipusOcupacio() {
		return new Cursets();
	}

	@Override
	public InfoOcupacio getInfoOcupacio() {
		return new InfoCursets();
	}

}
