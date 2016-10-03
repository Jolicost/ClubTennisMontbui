package Communicacio.Dades.Reserves;

import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.DadaIncorrecta;
import Communicacio.Excepcions.EntitatInvalida;
import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;

public class InfoReserva extends InfoFranja {
	private DateTime dataRealitzada;
	public InfoReserva(){}
	public DateTime getDataRealitzada() {
		return dataRealitzada;
	}
	public void setDataRealitzada(DateTime dataRealitzada) {
		this.dataRealitzada = dataRealitzada;
	}
	public String getTitol(){
		return "Reserva";
	}
	
	public InfoReserva toInfoReserva() throws DadaIncorrecta{
		return this;
	}
	
	public Info Populate(Map<String,String[]> params) throws IllegalArgumentException, IllegalAccessException, EntitatInvalida{	
		LocalTime i1 = LocalTime.parse(params.get("inici")[0]);
		LocalTime i2 = LocalTime.parse(params.get("fi")[0]);
		LocalDate d = LocalDate.parse(params.get("dia")[0]);
		
		Interval i = new Interval(d.toDateTime(i1),d.toDateTime(i2));
		this.setInterval(i);
		this.setDataRealitzada(DateTime.parse(params.get("dataRealitzada")[0]));
		return this;
		
	}
}
