package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoCursets;
import Communicacio.Dades.Reserves.InfoFranja;
import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;

public class Cursets extends Ocupacio {


	@Override
	public String getTipus() {
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
