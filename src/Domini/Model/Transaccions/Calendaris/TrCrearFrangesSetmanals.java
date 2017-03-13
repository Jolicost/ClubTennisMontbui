package Domini.Model.Transaccions.Calendaris;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.Interval;
import org.joda.time.LocalDate;

import Communicacio.Excepcions.EntitatInvalida;
import Domini.Model.Pista;
import Domini.Model.Calendaris.CalendariSetmanal;
import Domini.Model.Calendaris.CalendariSetmanalInvalid;
import Domini.Model.Reserves.Franja;
import Domini.Model.Transaccions.Transaccio;
import Factories.FactoriaControladors;

public abstract class TrCrearFrangesSetmanals extends Transaccio {

	public TrCrearFrangesSetmanals(int idCalendariSetmanal,int idPista, LocalDate inici, LocalDate fi) {
		super();
		this.idCalendariSetmanal = idCalendariSetmanal;
		this.idPista = idPista;
		this.inici = inici;
		this.fi = fi;
	}
	protected int idCalendariSetmanal;
	protected int idPista;
	protected LocalDate inici;
	protected LocalDate fi;
	@Override
	public void Executar() throws Exception {
		Pista p = LlegirPista(idPista);
		CalendariSetmanal c = LlegirCalendari(idCalendariSetmanal);
		Set<Interval> franges = crearIntervals(c,inici,fi);
		for (Interval i : franges){
			Franja f = crearFranjaBuida(c);
			f.setLapse(i);
			f.setPista(p);
			p.AfegirFranja(f);
		}
		FactoriaControladors.getInstance().getCtrlPista().Update(p);
	}
	

	protected Set<Interval> crearIntervals(CalendariSetmanal c, LocalDate inici, LocalDate fi) {
		Set<Interval> ret = new HashSet<>();
		LocalDate it = inici;
		while (it.isBefore(fi) || it.isEqual(fi)){
			ret.addAll(c.crearFranges(inici));
			inici.plusDays(1);
		}
		return ret;
	}
	
	protected Franja crearFranjaBuida(CalendariSetmanal c) throws EntitatInvalida, CalendariSetmanalInvalid{
		return c.crearFranja();
	}

}
