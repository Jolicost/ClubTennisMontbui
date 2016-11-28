package Domini.Model.Reserves;

import java.util.HashSet;
import java.util.Set;

import Domini.Model.Soci;

public abstract class NomesSocis extends ReservaSoci {
	public NomesSocis(){
		
	}
	public NomesSocis(Soci propietari) {
		super(propietari);
	}

	
	public boolean EsNomesSocis(){return true;}


}
