package Communicacio.Dades.Reserves.Tipus;

import Communicacio.Dades.Info;

public abstract class InfoTipusReserva extends Info {

	public InfoTipusReserva() {
		super();
	}
	
	private String tipus;
	
	public abstract String getTipus();
	
	public String getPanelFile(){
		return null;
	}
	
	public int getRestants(){
		return -1;
	}
	
	public void setRestants(int restants){
		
	}
	
	
	
}
