package Domini.Model.Reserves.Tipus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReserva;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;

public class FactoriaTipusReserva {
	private static FactoriaTipusReserva instance = new FactoriaTipusReserva();
	public static FactoriaTipusReserva getInstance(){return instance;}
	
	private Map<String,TipusReserva> tipus;
	
	private ReservaInvitacio ri = new ReservaInvitacio();
	private ReservaPagament rp = new ReservaPagament();
	private ReservaSN rsn = new ReservaSN();
	private ReservaNomesSocis rns = new ReservaNomesSocis();
	private ReservaTipusRanking rr = new ReservaTipusRanking();
	
	public FactoriaTipusReserva(){
		tipus = new HashMap<>();
		
		tipus.put(ri.getNom(),ri);
		tipus.put(rp.getNom(), rp);
		tipus.put(rsn.getNom(), rsn);
		tipus.put(rns.getNom(), rns);
		tipus.put(rr.getNom(),rr);
	}
	public ReservaInvitacio getInvitacio() {
		return ri;
	}
	public ReservaPagament getPagament() {
		return rp;
	}
	public ReservaSN getSenseReserva() {
		return rsn;
	}
	public ReservaNomesSocis getNomesSocis(){
		return rns;
	}
	public ReservaTipusRanking getRanking(){
		return rr;
	}
	public TipusReserva get(String tipus) throws TipusReservaInvalid{
		if (this.tipus.containsKey(tipus)){
			return this.tipus.get(tipus);
		}
		else throw new TipusReservaInvalid();
	}

	public ConfirmarReserva getConfirmar(String tipus) throws TipusReservaInvalid{
		return get(tipus).getConfirmar();
	}
	
	public InfoTipusReserva getInfo(String tipus) throws TipusReservaInvalid{
		return get(tipus).getInfo();
	}
	
	public TrComprovarTipus getTransaccioComprovarTipus(String tipus) throws TipusReservaInvalid{
		return get(tipus).crearTransaccioComprovar();
	}
	
	public Set<TrComprovarTipus> getTransaccionsCondicio(Predicate<TipusReserva> p){
		Set<TrComprovarTipus> ret = new HashSet<>();
		for (TipusReserva t: tipus.values()){
			if (p.test(t)) ret.add(t.crearTransaccioComprovar());
		}
		return ret;
	}
	
	
	public Set<String> getAll(){
		Set<String> ret = new HashSet<>();
		tipus.values().forEach(v -> ret.add(v.getNom()));
		return ret;
	}
	
	public Map<String,TipusReserva> getAllTipus(){
		return tipus;
	}

	public Set<TrComprovarTipus> getTransaccionsSeleccionables(){
		Predicate<TipusReserva> p = (t) -> t.EsSeleccionable();
		return getTransaccionsCondicio(p);
	}
	
	public TrObtenirConfirmacio getConfirmacioReserva(String tipus) throws TipusReservaInvalid{
		return this.get(tipus).crearTransaccioObtenirConfirmacio();
	}
}
