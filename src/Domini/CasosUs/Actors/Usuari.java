package Domini.CasosUs.Actors;

import Dades.Excepcions.BDExcepcio;
import Domini.MetaCasosUs.Accions.TrConsultarAccions;
import Domini.MetaCasosUs.Accions.TrConsultarAccionsRegistrat;

public class Usuari extends Registrat{

	public Usuari(String correu) throws BDExcepcio {
		super(correu);
	}


	@Override
	public String getRol() {
		return "admin";
	}

	@Override
	protected TrConsultarAccions getAccionsMembre() {
		return new TrConsultarAccionsRegistrat();
	}
}
