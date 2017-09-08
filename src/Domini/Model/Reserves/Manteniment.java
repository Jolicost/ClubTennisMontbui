package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.InfoManteniment;
import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;

public class Manteniment extends Ocupacio{


	@Override
	public String getTipus() {
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
