package Domini.Model.Transaccions.Calendaris;

import java.util.Iterator;
import java.util.Set;

import org.joda.time.Interval;
import org.joda.time.LocalDate;

import Domini.Model.Pista;
import Domini.Model.Calendaris.CalendariSetmanal;
import Domini.Model.Reserves.Franja;
import Factories.FactoriaControladors;

public abstract class TrEliminarFrangesSetmanals extends TrCrearFrangesSetmanals {

	public TrEliminarFrangesSetmanals(int idCalendariSetmanal,int idPista, LocalDate inici, LocalDate fi) {
		super(idCalendariSetmanal, idPista, inici, fi);
	}

	@Override
	public void Executar() throws Exception {
		Pista p = super.LlegirPista(idPista);
		CalendariSetmanal c = super.LlegirCalendari(idCalendariSetmanal);
		Set<Interval> franges = super.crearIntervals(c, inici, fi);
		borrarFranges(p,franges);		
		FactoriaControladors.getInstance().getCtrlPista().Update(p);
	}
	
	protected void borrarFranges(Pista p,Set<Interval> franges){
		Set<Franja> frangesPista = p.getFranges();
		Iterator<Franja> it = frangesPista.iterator();
		while (it.hasNext()){
			Franja f = it.next();
			if (franges.contains(f.getLapse()) && mustRemove(f)) it.remove();
		}
	}
	
	protected boolean mustRemove(Franja f){
		return true;
	}
	

}
