package Communicacio.Dades.Reserves.Confirmar;



import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import Communicacio.Dades.Reserves.InfoFranja;

public class InfoConfirmarReserva extends InfoFranja{

	public InfoConfirmarReserva() {
		super();
	}
	private String esport;
	
	public String getEsport() {
		return esport;
	}
	public void setEsport(String esport) {
		this.esport = esport;
	}

	
	public String getTipus(){
		return "reserva";
	}
	
	public double getPreu(){
		return 0;
	}
	
	public int getQuotaActual(){
		return -1;
	}
	
	public LocalDate getDia(){
		return i.getStart().toLocalDate();
	}
	
	public LocalTime getInici(){
		return i.getStart().toLocalTime();
	}
	
	public LocalTime getFi(){
		return i.getEnd().toLocalTime();
	}
	
	
	
	public String getView(){
		return null;
	}
	

}
