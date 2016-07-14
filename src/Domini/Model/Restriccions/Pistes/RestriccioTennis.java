package Domini.Model.Restriccions.Pistes;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Interval;

import Domini.Excepcions.MaximAntelacio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;

public class RestriccioTennis implements IRestriccionsPistes {

	private static final int MaxMills = 120 * 60* 1000;
	private static final Duration Max = new Duration(MaxMills);
	private static final int UnitMills = 15 * 60* 1000;
	private static final Duration Unit = new Duration(UnitMills);
	private static final Duration Min = new Duration(UnitMills * 3);
	
	@Override
	public void PotReservar(Soci s,Interval i) throws NoPotReservar {
		if (!CheckReservar(s,i.getStart())) throw new MaximAntelacio();
	}
	

	@Override
	public Set<Interval> Filtrar(Soci s,Set<Interval> in) {
		Set<Interval> ret = new HashSet<>();
		for (Interval i: in){
			if (CheckReservar(s,i.getStart())) ret.add(i);
		}
		return ret;
	}
	
	private boolean CheckReservar(Soci s, DateTime d)  {
		int dies = Days.daysBetween( DateTime.now(),d).getDays();
		if (dies > 4) return false;
		else return true;
	}

	@Override
	public Duration getMaxTempsReserva() {
		return Max;
	}

	@Override
	public Duration getMinTempsReserva() {
		return Min;
	}

	@Override
	public Duration getUnitatReserva() {
		return Unit;
	}



}
