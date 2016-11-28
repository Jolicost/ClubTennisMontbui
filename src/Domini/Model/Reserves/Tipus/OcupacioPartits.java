package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.InfoOcupacio;
import Communicacio.Dades.Reserves.InfoOcupacioPartits;
import Domini.Model.Reserves.Ocupacio;
import Domini.Model.Reserves.Partits;

public class OcupacioPartits extends TipusOcupacio{

	@Override
	public Ocupacio getTipusOcupacio() {
		return new Partits();
	}

	@Override
	public InfoOcupacio getInfoOcupacio() {
		return new InfoOcupacioPartits();
	}

	@Override
	public String getNom() {
		return "Partits";
	}

}
