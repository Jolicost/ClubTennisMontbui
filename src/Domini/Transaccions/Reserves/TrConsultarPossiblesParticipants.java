package Domini.Transaccions.Reserves;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.joda.time.Interval;

import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;
import Domini.Model.Transaccions.Transaccio;
import Domini.Model.Transaccions.SocisQuotaSuperada.TrQuotaSuperada;
import Domini.Model.Transaccions.SocisQuotaSuperada.TrQuotaSuperadaNomesSocis;
import Factories.FactoriaControladors;

public class TrConsultarPossiblesParticipants extends Transaccio{

	private Interval i;

	public TrConsultarPossiblesParticipants(Interval i){
		this.i = i;
	}
	private Set<Soci> result;
	@Override
	public void Executar() throws Exception {
		result = FactoriaControladors.getInstance().getCtrlSoci().getAll();
		TrQuotaSuperada tr = new TrQuotaSuperadaNomesSocis(i,obtenirReserves(result));
		tr.Executar();
		result.removeAll(tr.getResult());
	}
	
	public Set<Soci> getResult(){
		return result;
	}
	
	protected Set<ReservaSoci> obtenirReserves(Set<Soci> socis){
		Set<ReservaSoci> ret = new HashSet<>();
		for (Soci s: socis) ret.addAll(s.getReserves());
		return ret;
	}
	

}
