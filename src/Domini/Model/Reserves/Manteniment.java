package Domini.Model.Reserves;

import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.InfoManteniment;
import Communicacio.Xarxa.Domini.Entitats.Ocupacio.FactoriaTipusOcupacio;

public class Manteniment extends Ocupacio{


	@Override
	protected String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getManteniment();
	}
	
	public boolean EsOcupacioClub(){
		return true;
	}

	@Override
	protected InfoFranja crearInfo() {
		return new InfoManteniment();
	}
	

}
