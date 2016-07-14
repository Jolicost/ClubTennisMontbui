package Communicacio.Dades.Reserves;

import Communicacio.Dades.Info;

public class InfoTipus extends Info {

	public InfoTipus(String tipus) {
		super();
		this.tipus = tipus;
	}

	public InfoTipus() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String tipus;

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
}
