package Communicacio.Dades;

import org.joda.time.LocalTime;

public class InfoDiaSetmana extends Info {

	public int diaSetmana;
	private LocalTime inici;
	private LocalTime fi;
	
	public InfoDiaSetmana(){
		
	}
	
	public int getDiaSetmana() {
		return diaSetmana;
	}
	public void setDiaSetmana(int diaSetmana) {
		this.diaSetmana = diaSetmana;
	}
	public LocalTime getInici() {
		return inici;
	}
	public void setInici(LocalTime inici) {
		this.inici = inici;
	}
	public LocalTime getFi() {
		return fi;
	}
	public void setFi(LocalTime fi) {
		this.fi = fi;
	}

}
