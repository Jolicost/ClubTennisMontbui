package Communicacio.Dades.Reserves;

import org.joda.time.Interval;

public class InfoLliure extends InfoFranja {

	public InfoLliure() {

	}

	public InfoLliure(Interval y) {
		super();
		super.setInterval(y);
	}
	
	public String getTipus(){
		return "Lliure";
	}


}
