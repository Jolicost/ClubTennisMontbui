package Communicacio.Dades.Reserves;

import org.joda.time.DateTime;
import org.joda.time.Interval;

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
}
