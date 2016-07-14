package Communicacio.Dades.PujarSocis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;

public class InfoPlantillaSocis extends Info {
	private InfoPlantillaSoci[] socis;
	
	public InfoPlantillaSocis(){
		
	}

	public InfoPlantillaSoci[] getSocis() {
		return socis;
	}

	public void setSocis(InfoPlantillaSoci[] socis) {
		this.socis = socis;
	}
	
	public Set<InfoPlantillaSoci> getSetSocis(){
		return new HashSet<InfoPlantillaSoci>(Arrays.asList(socis));
	}
	
	
}
