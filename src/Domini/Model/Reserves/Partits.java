package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.InfoOcupacioPartits;
import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;

public class Partits extends Ocupacio {

	@Override
	public String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getPartits();
	}

	@Override
	protected InfoFranja crearInfo() {
		return new InfoOcupacioPartits();
	}

}
