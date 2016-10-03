package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.InfoManteniment;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Domini.Model.Reserves.Manteniment;
import Domini.Model.Reserves.Ocupacio;

public class OcupacioManteniment extends TipusOcupacio {

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
