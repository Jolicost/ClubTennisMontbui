package Communicacio.Dades.Reserves.Correus;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoSoci;
import Communicacio.Dades.Reserves.InfoFranja;

public class InfoReservaRealitzada extends Info {
	private InfoSoci is;
	public int getNumero() {
		return is.getNumero();
	}

	public String getDni() {
		return is.getDni();
	}

	public String getNom() {
		return is.getNom();
	}

	public String getCognoms() {
		return is.getCognoms();
	}

	public String getTipus() {
		return i.getTipus();
	}

	public String getNomPista() {
		return i.getNomPista();
	}

	public String getEsport() {
		return i.getEsport();
	}

	public String getIniciFormat() {
		return i.getIniciFormat();
	}

	public String getFiFormat() {
		return i.getFiFormat();
	}

	public String getDiaFormat() {
		return i.getDiaFormat();
	}

	private InfoFranja i;
	
	public InfoReservaRealitzada(InfoSoci is,InfoFranja i){
		this.is = is;
		this.i = i ;
	}

	public int getIdFranja() {
		return i.getIdFranja();
	}


	
}
