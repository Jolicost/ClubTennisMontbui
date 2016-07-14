package Domini.Model.Reserves;

import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.Reserves.InfoAltres;
import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Communicacio.Xarxa.Domini.Entitats.Ocupacio.FactoriaTipusOcupacio;

public class Altres extends Ocupacio {
	public Altres(){}
	public Altres(String motiu) {
		super();
		this.motiu = motiu;
	}
	private String motiu;
	
	public String getMotiu() {
		return motiu;
	}
	public void setMotiu(String motiu) {
		this.motiu = motiu;
	}
	
	public void Populate(InfoOcupacio io){
		super.Populate(io);
		this.setMotiu(io.getMotiu());
	}
	@Override
	protected String getTipus() {
		return FactoriaTipusOcupacio.getInstance().getAltres();
	}
	
	public boolean EsOcupacioClub(){
		return true;
	}

	@Override
	protected InfoFranja crearInfo() {
		return new InfoAltres();
	}

}
