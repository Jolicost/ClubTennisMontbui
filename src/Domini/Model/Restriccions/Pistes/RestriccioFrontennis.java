package Domini.Model.Restriccions.Pistes;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Interval;

import Domini.Excepcions.MassesReserves;
import Domini.Excepcions.MaximAntelacio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;
import Domini.Model.Restriccions.RestriccioSenseReserva;

public class RestriccioFrontennis implements IRestriccionsPistes{

	private static final int MaxMills = 60 * 60* 1000;
	private static final Duration Max = new Duration(MaxMills);
	private static final int UnitMills = 15 * 60* 1000;
	private static final Duration Unit = new Duration(UnitMills);
	private static final Duration Min = new Duration(UnitMills * 2);
	

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


	@Override
	public void PotReservar(Soci s,Interval d) throws NoPotReservar {
		int i = s.getReservesCondicio(crearVigentsFronto()).size();
		CheckReservar(d,i);
	}
	
	private void CheckReservar(Interval in,int ReservesVigents) throws NoPotReservar{
		int i = ReservesVigents;
		if (i == 0){
			int dies = Days.daysBetween( DateTime.now(),in.getStart()).getDays();
			if (dies >= 7) throw new MaximAntelacio();
		}
		else if (i == 1){
			int dies = Days.daysBetween( DateTime.now(),in.getStart()).getDays();
			if(dies >= 3) throw new MaximAntelacio();
		}
	}
	
	private boolean CheckReservarBool(Interval in,int ReservesVigents){
		int i = ReservesVigents;
		if (i == 0){
			int dies = Days.daysBetween( DateTime.now(),in.getStart()).getDays();
			if (dies >= 7) return false;
		}
		else if (i == 1){
			int dies = Days.daysBetween( DateTime.now(),in.getStart()).getDays();
			if(dies >= 3) return false;
		}
		return true;
	}

	@Override
	public Set<Interval> Filtrar(Soci s, Set<Interval> in) {
		int n = s.getReservesCondicio(crearVigentsFronto()).size();
		Set<Interval> ret = new HashSet<>();
		for (Interval i: in){
			if (CheckReservarBool(i,n)){
				ret.add(i);
			}
		}
		return ret;
		
	}
	
	private Predicate<ReservaSoci> crearVigentsFronto(){
		Predicate<ReservaSoci> ret = rs -> rs.EsFronto() && rs.EstaActiva() && !rs.EsSenseReserva();
		return ret;
	}

	@Override
	public boolean Test(Soci s, Interval in) {
		int i = s.getReservesCondicio(crearVigentsFronto()).size();
		return CheckReservarBool(in,i);
	}

}
