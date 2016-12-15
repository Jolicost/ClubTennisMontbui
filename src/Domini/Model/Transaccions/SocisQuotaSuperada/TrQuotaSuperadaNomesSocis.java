package Domini.Model.Transaccions.SocisQuotaSuperada;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.Interval;

import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class TrQuotaSuperadaNomesSocis extends TrQuotaSuperada {

	public TrQuotaSuperadaNomesSocis(Interval i,Set<ReservaSoci> reserves) {
		super(i, reserves);

	}

	@Override
	protected Interval getIntervalPertanyent() {
		return FactoriaTipusReserva.getInstance().getNomesSocis().getIntervalPertanyent(super.i);
	}

	@Override
	protected Set<Soci> obtenirParticipants(ReservaSoci r) {
		Set<Soci> ret = new HashSet<>();
		ret.addAll(r.getJugadors());
		ret.add(r.getPropietari());
		Set<Soci> virtuals = new HashSet<>();
		for (Soci s: ret){
			virtuals.addAll(s.getMembresNE());
		}
		ret.addAll(virtuals);
		return ret;
	}

	@Override
	protected int getMaximaQuota(Soci s) {
		return s.getMaxReservesSetmana();
	}

	@Override
	protected boolean ReservaValida(ReservaSoci r) {
		return r.EsAnticipada() || r.EsPagament();
	}

}
