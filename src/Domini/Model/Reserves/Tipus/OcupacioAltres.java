package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.InfoAltres;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Domini.Model.Reserves.Altres;
import Domini.Model.Reserves.Ocupacio;

public class OcupacioAltres extends TipusOcupacio {

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
