package Communicacio.Xarxa.Domini.Entitats.Ocupacio;

import Communicacio.Dades.Reserves.InfoOcupacio;
import Domini.Model.Reserves.Ocupacio;

public abstract class EntitatTipusOcupacio {

	public abstract String getNom();
	public abstract Ocupacio getTipusOcupacio();
	public abstract InfoOcupacio getInfoOcupacio();
}
