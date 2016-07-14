package Domini.Model.Reserves;

import java.util.HashSet;
import java.util.Set;

import Domini.Model.Soci;

public abstract class NomesSocis extends ReservaSoci {
	public NomesSocis(){
		jugadors = new HashSet<>();
	}
	public NomesSocis(Soci propietari,Set<Soci> jugadors) {
		super(propietari);
		this.jugadors = jugadors;
	}
	private Set<Soci> jugadors;
	
	public Set<Soci> getJugadors() {
		return jugadors;
	}
	public void setJugadors(Set<Soci> jugadors) {
		this.jugadors = jugadors;
	}
	
	public boolean EsNomesSocis(){return true;}
	public boolean Participa(Soci s){
		return jugadors.contains(s);
	}

}
