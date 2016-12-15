package Domini.Model.Restriccions;

import java.util.Set;
import java.util.function.Predicate;

import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;

public class RestriccioNomesSocis extends RestriccioAnticipada{

	public RestriccioNomesSocis(Soci s, Pista p) {
		super(s, p);
	}
	
	@Override
	protected Predicate<ReservaSoci> createPredicate() {
		Predicate<ReservaSoci> ret = rt -> rt.EsAnticipada() || rt.EsPagament();
		return ret;
	}
	
	protected Set<ReservaSoci> obtenirReservesRealitzades(Soci s,Predicate<ReservaSoci> cond){
		 return s.getReservesParticipaCondicio(cond);
	}

}
