package Domini.Model.Restriccions;

import java.util.Set;
import java.util.function.Predicate;

import org.joda.time.Duration;
import org.joda.time.Interval;

import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Ranking.FactoriaRanking;
import Domini.Model.Reserves.ReservaSoci;

public class RestriccioRanking extends RestriccioAnticipada {

	public RestriccioRanking(Soci s,Pista p) {
		super(s,p);
	}

	@Override
	protected int getLimit() {
		return 1;
	}

	@Override
	protected Predicate<ReservaSoci> createPredicate() {
		Predicate<ReservaSoci> ret = rt -> rt.EsRanking();
		return ret;
	}
	
	@Override
	protected Duration getMaximaAnticipacio() {
		return super.getMaximaAnticipacio().plus(Duration.standardDays(2));
	}

	
	@Override
	protected boolean TestPista(Interval i) {
		boolean llistat = FactoriaRanking.getInstance().getSistemaRanking().getSocisRanking().contains(super.s.getNumero());
		
		if (llistat){
			boolean anticipacio = this.TestAntelacio(i);
			boolean tennis = p.EsTennis();
			
			return anticipacio && tennis;
		}
		return false;
	}
	
	protected Set<ReservaSoci> obtenirReservesRealitzades(Soci s,Predicate<ReservaSoci> cond){
		 return s.getReservesPropietariCondicio(cond);
		
	}
}
