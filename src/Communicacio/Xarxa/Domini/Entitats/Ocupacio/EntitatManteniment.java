package Communicacio.Xarxa.Domini.Entitats.Ocupacio;

import Communicacio.Dades.Reserves.InfoManteniment;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Domini.Model.Reserves.Manteniment;
import Domini.Model.Reserves.Ocupacio;

public class EntitatManteniment extends EntitatTipusOcupacio {

	@Override
	public String getNom() {
		return "manteniment";
	}

	@Override
	public Ocupacio getTipusOcupacio() {
		return new Manteniment();
	}

	@Override
	public InfoOcupacio getInfoOcupacio() {
		return new InfoManteniment();
	}

}
