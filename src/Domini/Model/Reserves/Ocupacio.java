package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoOcupacio;

public abstract class Ocupacio extends Franja {
	
	public boolean EsOcupada(){
		return true;
	}

	
	public abstract String getTipus();


	public void Populate(InfoOcupacio io) {
		super.Populate(io);
	}
	

}
