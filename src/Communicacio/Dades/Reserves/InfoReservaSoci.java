package Communicacio.Dades.Reserves;

import java.util.HashSet;
import java.util.Set;

import Communicacio.Excepcions.DadaIncorrecta;

public class InfoReservaSoci extends InfoReserva {

	public InfoReservaSoci(){
		participants = new HashSet<>();
	}
	
	private String nomSoci;
	private boolean Cancelable;
	private Set<String> participants;
	
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

	public Set<String> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<String> participants) {
		this.participants = participants;
	}
	
	public String printParticipants(){
		return participants.toString();
	}
	
	

}
