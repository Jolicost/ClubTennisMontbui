package Domini.Model.Calendaris;

import Communicacio.Dades.InfoCalendariOcupacions;
import Communicacio.Dades.InfoCalendariSetmanal;
import Communicacio.Excepcions.DadaIncorrecta;
import Communicacio.Excepcions.EntitatInvalida;
import Domini.Model.Reserves.Franja;
import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;

public class CalendariOcupacions extends CalendariSetmanal {
	private String tipus;
	public CalendariOcupacions(){
		super();
	}
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	@Override
	public Franja crearFranja() throws CalendariSetmanalInvalid, EntitatInvalida {
		return FactoriaTipusOcupacio.getInstance().getOcupacio(tipus);
	}
	@Override
	protected InfoCalendariSetmanal crearInfo() {
		InfoCalendariOcupacions ret = new InfoCalendariOcupacions();
		ret.setTipus(this.tipus);
		return ret;
	}
	
	@Override
	public void populate(InfoCalendariSetmanal info) throws DadaIncorrecta {
		super.populate(info);
		this.setTipus(info.toInfoCalendariOcupacions().getTipus());
	}
	
	
}
