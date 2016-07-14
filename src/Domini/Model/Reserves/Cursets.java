package Domini.Model.Reserves;

import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.Reserves.InfoCursets;
import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Xarxa.Domini.Entitats.Ocupacio.FactoriaTipusOcupacio;

public class Cursets extends Ocupacio {


	@Override
	protected String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getCursets();
	}
	
	public boolean EsOcupacioClub(){
		return true;
	}

	@Override
	protected InfoFranja crearInfo() {
		return new InfoCursets();
	}
}
