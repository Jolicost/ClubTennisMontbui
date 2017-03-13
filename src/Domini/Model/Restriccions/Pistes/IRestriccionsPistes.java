package Domini.Model.Restriccions.Pistes;

import java.util.Set;

import org.joda.time.Duration;
import org.joda.time.Interval;

import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;

public interface IRestriccionsPistes {
	public void PotReservar(Soci s,Interval i) throws NoPotReservar;
	public Duration getMaxTempsReserva();
	public Duration getMinTempsReserva();
	public Duration getUnitatReserva();
	
	public Set<Interval> Filtrar(Soci s,Set<Interval> in);
	public boolean Test(Soci s,Interval in);
}
