package Communicacio.Dades.Accions;

import java.util.ArrayList;
import java.util.List;

import Communicacio.Dades.Info;

public class InfoAccio extends Info {

	private String titol;

	private String dispacher;
	
	public InfoAccio(){
		dispacher = "index";
	}
	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}
	
	public List<InfoAccio> getAccions() {
		return new ArrayList<>();
	}
	
	public String getDispacher() {
		return dispacher;
	}
	
	public boolean EsGrup(){
		return false;
	}
	
	public String getGlyph(){
		return "";
	}

	public void setDispacher(String dispacher) {
		this.dispacher = dispacher;
	}
}
