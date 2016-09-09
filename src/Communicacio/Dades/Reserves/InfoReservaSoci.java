package Communicacio.Dades.Reserves;

import java.time.Instant;

import org.joda.time.Interval;

import Communicacio.Excepcions.DadaIncorrecta;

public class InfoReservaSoci extends InfoReserva {

	public InfoReservaSoci(){}
	
	private String nomSoci;
	private boolean Cancelable;

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

	public boolean isCancelable() {
		return Cancelable;
	}

	public void setCancelable(boolean cancelable) {
		Cancelable = cancelable;
	}
	
	public InfoReservaSoci toInfoReservaSoci() throws DadaIncorrecta{
		return this;
	}
	
	

}
