package Domini.Transaccions.InsertarFranja;

import org.joda.time.Interval;

import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Reserves.Franja;
import Domini.Model.Reserves.Ocupacio;

public abstract class TrOcuparPista extends TrOcuparFranja {
	
	
	public TrOcuparPista(Pista p,Interval dur){
		super(p,dur);
	}
	
	protected Franja ObtenirFranja() throws NoPotReservar, BDExcepcio{
		return ObtenirOcupacio();
	}
	
	protected abstract Ocupacio ObtenirOcupacio() throws NoPotReservar, BDExcepcio;
	
}
