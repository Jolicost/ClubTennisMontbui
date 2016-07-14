package Communicacio.Dades;

import java.util.Set;

public class InfoPistes extends Info {
	public InfoPistes(Set<InfoHorari> pistes) {
		super();
		this.pistes = pistes;
	}

	public InfoPistes() {
		
	}

	private Set<InfoHorari> pistes;

	@Override
	public String toString() {
		return "InfoPistes [pistes=" + pistes + "]";
	}
	
}
