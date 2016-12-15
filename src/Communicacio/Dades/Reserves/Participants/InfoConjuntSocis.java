package Communicacio.Dades.Reserves.Participants;

import java.util.Set;

import Communicacio.Dades.Info;

public class InfoConjuntSocis extends Info{
	private Set<Integer> socis;

	public Set<Integer> getSocis() {
		return socis;
	}

	public void setSocis(Set<Integer> socis) {
		this.socis = socis;
	}
}
