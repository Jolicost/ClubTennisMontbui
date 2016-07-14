package Communicacio.Dades.Reserves;


import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.DadaIncorrecta;
import Communicacio.Excepcions.EntitatInvalida;
import Communicacio.Xarxa.Domini.Entitats.Ocupacio.FactoriaTipusOcupacio;

public class InfoOcupacio extends InfoFranja {

	public InfoOcupacio(){}
	public InfoOcupacio(Interval i, int iD) {
		super();
		super.setIdPista(iD);
		super.setInterval(i);
		
	}

	public String motiu;
	


	public String getMotiu() {
		return motiu;
	}
	public void setMotiu(String motiu) {
		this.motiu = motiu;
	}
	
	public InfoOcupacio toInfoOcupacio() throws DadaIncorrecta{
		return this;
	}
	
	public String getTitol(){
		return "Ocupacio"; 
	}

	
	public Info Populate(Map<String,String[]> params) throws IllegalArgumentException, IllegalAccessException, EntitatInvalida{	
		LocalTime i1 = LocalTime.parse(params.get("inici")[0]);
		LocalTime i2 = LocalTime.parse(params.get("fi")[0]);
		LocalDate d = LocalDate.parse(params.get("dia")[0]);
		
		String tipus = params.get("tipus")[0];
		InfoOcupacio ret = FactoriaTipusOcupacio.getInstance().createInfo(tipus);
		Interval i = new Interval(d.toDateTime(i1),d.toDateTime(i2));
		ret.setInterval(i);
		return ret;
		
	}
	
	public String getTipus(){
		return "Ocupacio";
	}

}
