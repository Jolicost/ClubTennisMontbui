package Communicacio.Dades;

import Communicacio.Excepcions.DadaIncorrecta;

public class InfoOcupacions extends InfoObertures{

	private String tipus;

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
	public InfoOcupacions toInfoOcupacions() throws DadaIncorrecta{
		return this;
	}
}
