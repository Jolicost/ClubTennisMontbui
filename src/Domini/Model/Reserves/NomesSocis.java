package Domini.Model.Reserves;

import Domini.Model.Soci;

public abstract class NomesSocis extends ReservaSoci {
	public NomesSocis(){
		
	}
	public NomesSocis(Soci propietari) {
		super(propietari);
	}

	
	public boolean EsNomesSocis(){return true;}


}
