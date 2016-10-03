package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.InfoCursets;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Domini.CasosUs.Gestors.Franges.GestorFranja;
import Domini.Model.Reserves.Cursets;
import Domini.Model.Reserves.Ocupacio;

public class OcupacioCursets extends TipusOcupacio {

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
