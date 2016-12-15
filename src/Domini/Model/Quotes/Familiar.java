package Domini.Model.Quotes;

import java.util.HashSet;
import java.util.Set;

import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;

public abstract class Familiar extends Quota {



	
	
	public Set<ReservaSoci> ObtenirReserves(){
		Set<ReservaSoci> ret = new HashSet<>();
		for (Familiar f: obtenirFamiliars()) ret.addAll(f.obtenirReservesPropies());
		return ret;
	}
	
	public Set<ReservaSoci> ObtenirReservesParticipa(){
		Set<ReservaSoci> ret = new HashSet<>();
		for (Familiar f: obtenirFamiliars()) ret.addAll(f.obtenirReservesParticipa());
		return ret;
	}
	
	protected abstract Set<Familiar> obtenirFamiliars();
	
	protected Set<ReservaSoci> obtenirReservesPropies(){
		return super.getPropietari().getReserves();
	}
	
	protected Set<ReservaSoci> obtenirReservesParticipa(){
		return super.getPropietari().getParticipa();
	}

	@Override
	public int getReservesSetmana() {
		return 3;
	}


	@Override
	public Set<Soci> getMembresNE() {
		Set<Soci> ret = new HashSet<>();
		for (Familiar f: this.obtenirFamiliars()){
			ret.add(f.getPropietari());
		}
		return ret;
	}
}
