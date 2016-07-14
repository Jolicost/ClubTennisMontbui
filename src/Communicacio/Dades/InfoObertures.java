package Communicacio.Dades;

import java.util.Set;

import org.joda.time.LocalDate;

import Communicacio.Excepcions.DadaIncorrecta;

public class InfoObertures extends Info{

	public InfoObertures() {
		super();
	}
	private InfoDiaSetmana[] dies;
	private LocalDate inici;
	private LocalDate fi;
	
	

	public LocalDate getInici() {
		return inici;
	}
	public void setInici(LocalDate inici) {
		this.inici = inici;
	}
	public LocalDate getFi() {
		return fi;
	}
	public void setFi(LocalDate fi) {
		this.fi = fi;
	}
	
	public InfoObertures toInfoObertures() throws DadaIncorrecta{
		return this;
	}
	public InfoDiaSetmana[] getDies() {
		return dies;
	}
	public void setDies(InfoDiaSetmana[] dies) {
		this.dies = dies;
	}
	
}
