package Domini.Model.Restriccions;

import java.util.Set;

import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;

public interface IRestriccio {

	
	public Set<Interval> Filtrar(Set<Interval> in);
	public int Test(Interval in) throws NoPotReservar;
}
