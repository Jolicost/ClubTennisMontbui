package Communicacio.Dades.Reserves;

import org.joda.time.DateTime;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.DadaIncorrecta;

public class InfoReservar extends Info {

	public InfoReservar(int iDPista) {
		super();
		IDPista = iDPista;
	}
	public InfoReservar(){
		
	}

	private int IDPista;
	private DateTime inici;
	private DateTime fi;

	public int getIDPista() {
		return IDPista;
	}

	public void setIDPista(int iDPista) {
		IDPista = iDPista;
	}
	
	public InfoReservar toInfoReservar() throws DadaIncorrecta{
		return this;
	}
	public DateTime getInici() {
		return inici;
	}
	public void setInici(DateTime inici) {
		this.inici = inici;
	}
	public DateTime getFi() {
		return fi;
	}
	public void setFi(DateTime fi) {
		this.fi = fi;
	}
}
