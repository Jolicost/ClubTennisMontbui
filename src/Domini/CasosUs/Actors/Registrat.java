package Domini.CasosUs.Actors;

import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.ActorInvalid;
import Factories.FactoriaControladors;

public abstract class Registrat extends Actor {

	protected String correu;
	protected int rang;
	
	public String getCorreu() {
		return correu;
	}
	
	@Override
	protected int getRang() {
		return rang;
	}
	

	public Registrat(String correu) throws BDExcepcio{
		this.correu = correu;
		rang = FactoriaControladors.getInstance().getCtrlUsuari().get(correu).getRangOriginal().getPermis();
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}
	
	public Registrat getRegistrat() throws ActorInvalid{
		return this;
	}

	
}
