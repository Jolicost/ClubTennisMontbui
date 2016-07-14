package Domini.CasosUs.Actors;

import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.ActorInvalid;
import Domini.MetaCasosUs.Accions.TrConsultarAccions;
import Domini.MetaCasosUs.Accions.TrConsultarAccionsSoci;

public class Soci extends Registrat {

	public Soci(int numero,String correu) throws BDExcepcio {
		super(correu);
		this.numero = numero;
	}

	protected int numero;
	
	
	public Soci getSoci() throws ActorInvalid{
		return this;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String getRol() {
		return "admin";
	}
	
	protected boolean EsSoci(){
		return true;
	}

	@Override
	protected TrConsultarAccions getAccionsMembre() {
		return new TrConsultarAccionsSoci();
	}
}
