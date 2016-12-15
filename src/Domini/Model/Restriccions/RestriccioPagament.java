package Domini.Model.Restriccions;

import java.util.Set;
import java.util.function.Predicate;

import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;

public class RestriccioPagament extends RestriccioAnticipada {

	public RestriccioPagament(Soci s, Pista p) {
		super(s, p);
	}
	
	@Override
	protected Predicate<ReservaSoci> createPredicate() {
		Predicate<ReservaSoci> ret = rt -> rt.EsPagament() || rt.EsAnticipada();
		return ret;
	}
	
	protected Set<ReservaSoci> obtenirReservesRealitzades(Soci s,Predicate<ReservaSoci> cond){
		 return s.getReservesParticipaCondicio(cond);
	}

}
