package Domini.Model.Restriccions;

import java.util.Set;

import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;

public class RestriccioPista implements IRestriccio {

	private Pista p;
	private Soci s;
	public RestriccioPista(Pista p,Soci s){
		this.p = p;
		this.s = s;
	}
	@Override
	public Set<Interval> Filtrar(Set<Interval> in) {
		return p.getRestriccions().Filtrar(s,in);
	}
	@Override
	public int Test(Interval in) throws NoPotReservar {
		p.getRestriccions().PotReservar(s, in);
		return 0;
	}

}
