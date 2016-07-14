package Domini.CasosUs.Controladors.Quotes;

import java.util.Set;
import java.util.function.Predicate;

import Domini.Model.Soci;
import Domini.Model.Quotes.Quota;
import Factories.FactoriaControladors;

public class RestriccionsQuotaFamiliar {

	private Soci s;
	public RestriccionsQuotaFamiliar(Soci s){
		this.s = s;
	}
	
	
	public boolean Test(Soci t) throws Exception{
		if (t.QuotaCompleix(getRestriccio())) return true;
		else return false;
	}
	
	public Set<Soci> getAll() throws Exception{
		Set<Soci> ret = FactoriaControladors.getInstance().getCtrlSoci().getAll();
		ret.removeIf(s -> !s.QuotaCompleix(getRestriccio()));
		return ret;
	}
	
	private Predicate<Quota> getRestriccio(){
		Predicate<Quota> p = q -> q.EsTitular() && q.getPropietari().getNumero() != s.getNumero();
		return p;
	}
	
	
}
