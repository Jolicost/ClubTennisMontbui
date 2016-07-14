package Domini.Model.Quotes;

import java.util.HashSet;
import java.util.Set;

import Domini.Model.Reserves.ReservaSoci;

public abstract class Familiar extends Quota {



	
	
	public Set<ReservaSoci> ObtenirReserves(){
		Set<ReservaSoci> ret = new HashSet<>();
		for (Familiar f: obtenirFamiliars()) ret.addAll(f.obtenirReservesPropies());
		return ret;
	}
	
	protected abstract Set<Familiar> obtenirFamiliars();
	
	protected Set<ReservaSoci> obtenirReservesPropies(){
		return super.getPropietari().getReserves();
	}

	@Override
	public int getReservesSetmana() {
		return 3;
	}
}
