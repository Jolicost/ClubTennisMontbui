package Domini.Model.Reserves;

import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.InfoLliure;
import Domini.Model.Reserves.Tipus.TipusFranja;

public class Lliure extends Franja {


	public boolean EsLliure(){
		return true;
	}

	@Override
	protected InfoFranja crearInfo() {
		return new InfoLliure();
	}

	@Override
	public String getTipus() {
		// TODO Auto-generated method stub
		return null;
	}


}
