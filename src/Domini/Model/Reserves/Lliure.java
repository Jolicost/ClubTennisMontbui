package Domini.Model.Reserves;

import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.InfoLliure;

public class Lliure extends Franja {


	public boolean EsLliure(){
		return true;
	}

	@Override
	protected InfoFranja crearInfo() {
		return new InfoLliure();
	}
}
