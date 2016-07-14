package Communicacio.Dades.Reserves;

import java.time.Instant;

import org.joda.time.Interval;

public class InfoReservaSoci extends InfoReserva {

	public InfoReservaSoci(){}
	
	private String nomSoci;

	public String getNomSoci() {
		return nomSoci;
	}

	public void setNomSoci(String nomSoci) {
		this.nomSoci = nomSoci;
	}
	
	public String getTitol(){
		String ret = super.getTitol();
		return ret + ", " + nomSoci; 
	}
	
	

}
