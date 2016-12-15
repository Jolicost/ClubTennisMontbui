package Communicacio.Dades.Reserves.Participants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoSoci;

public class InfoTriarParticipants extends Info{
	private int minim;
	private int maxim;
	
	private Set<InfoSoci> socis;
	
	public InfoTriarParticipants(){
		
	}

	public int getMinim() {
		return minim;
	}

	public void setMinim(int minim) {
		this.minim = minim;
	}

	public int getMaxim() {
		return maxim;
	}

	public void setMaxim(int maxim) {
		this.maxim = maxim;
	}

	public Set<InfoSoci> getSocis() {
		return socis;
	}

	public void setSocis(Set<InfoSoci> socis) {
		this.socis = socis;
	}
	
	public Set<List<String>> getAtributsSocis(){
		Set<List<String>> ret = new HashSet<>();
		for (InfoSoci is: this.socis){
			ret.add(is.getAttributeValues());
		}
		return ret;
	}
	
	public Set<List<String>> getPublicAttributesSocis(){
		Set<List<String>> ret = new HashSet<>();
		for (InfoSoci is: this.socis){
			ret.add(is.getPublicAttributesValues());
		}
		return ret;
	}
}
