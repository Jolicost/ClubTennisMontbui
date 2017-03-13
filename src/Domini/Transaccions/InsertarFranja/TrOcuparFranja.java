package Domini.Transaccions.InsertarFranja;

import org.joda.time.Interval;

import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Excepcions.PistaOcupada;
import Domini.Model.Pista;
import Domini.Model.Reserves.Franja;

public abstract class TrOcuparFranja {
	protected Pista p;
	protected Interval Duracio;
	protected Franja result;
	
	public TrOcuparFranja(Pista p,Interval dur){
		this.p = p;
		Duracio = dur;
	}
	
	public Franja getResult(){return result;}
	
	
	public void Executar() throws NoPotReservar, BDExcepcio{
		if (p.EstaOcupada(Duracio)) throw new PistaOcupada();
		Franja f = ObtenirFranja();
		f.setPista(p);
		f.setLapse(Duracio);
		p.AfegirFranja(f);
		
		result = f;
	}
	
	protected abstract Franja ObtenirFranja() throws NoPotReservar, BDExcepcio;
}
