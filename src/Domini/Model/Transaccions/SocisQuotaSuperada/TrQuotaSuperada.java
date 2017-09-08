package Domini.Model.Transaccions.SocisQuotaSuperada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.Interval;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;
import Domini.Model.Transaccions.Transaccio;

public abstract class TrQuotaSuperada extends Transaccio{

	protected Set<Soci> result;
	protected Interval i;
	protected Set<ReservaSoci> reserves;
	
	public TrQuotaSuperada(Interval i,Set<ReservaSoci> reserves){
		this.i = i;
		this.reserves = reserves;
	}
	
	public Set<Soci> getResult(){
		return result;
	}
	@Override
	public void Executar() throws Exception {
		result = this.Filtrar(
					this.crearMapa(
						this.obtenirAparicions(
								this.obtenirReserves()
						)
					)
				);
	}
	
	protected abstract Interval getIntervalPertanyent();
	
	protected Set<ReservaSoci> obtenirReserves() throws BDExcepcio{
		Set<ReservaSoci> ret = new HashSet<>();
 		Interval f = this.getIntervalPertanyent();
		for (ReservaSoci r : reserves){
			if (ReservaValida(r) && r.Intersecciona(f)) ret.add(r);
		}
		return ret;
	}
	
	protected abstract boolean ReservaValida(ReservaSoci r);
	
	protected List<Soci> obtenirAparicions(Set<ReservaSoci> reserves){
		List<Soci> ret = new ArrayList<>();
		for (ReservaSoci r: reserves){
 			ret.addAll(this.obtenirParticipants(r));
		}
		return ret;
	}
	
	protected Map<Soci,Integer> crearMapa(List<Soci> aparicions){
		Map<Soci,Integer> ret = new HashMap<>();
		for (Soci s: aparicions){
			int n = 1;
			if (ret.containsKey(s)) n += ret.get(s);
			ret.put(s, n);
		}
		return ret;
	}
	
	protected Set<Soci> Filtrar(Map<Soci,Integer> mapa){
		Set<Soci> ret = new HashSet<>();
		for (Soci s: mapa.keySet()){
			if (mapa.get(s) >= getMaximaQuota(s)){
				ret.add(s);
			}
		}
		return ret;
	}
	
	protected abstract Set<Soci> obtenirParticipants(ReservaSoci r);

	protected abstract int getMaximaQuota(Soci s);
}
