package Domini.Model.Restriccions;

import java.util.function.Predicate;

import org.joda.time.Interval;

import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;

public class RestriccioAnticipada extends RestriccioReservaLimitada {

	public RestriccioAnticipada(Soci s) {
		super(s);
	}

	@Override
	protected int getTimeKey(Interval i) {
		return i.getStart().getWeekOfWeekyear();
	}

	@Override
	protected Interval getIntervalPertanyent(Interval i) {
		return new Interval(i.getStart().dayOfWeek().withMinimumValue().millisOfDay().withMinimumValue(),
							i.getStart().dayOfWeek().withMaximumValue().millisOfDay().withMaximumValue());
	}

	@Override
	protected int getLimit() {
		return s.getMaxReservesSetmana();
	}

	@Override
	protected Predicate<ReservaSoci> createPredicate() {
		Predicate<ReservaSoci> ret = rt -> !rt.EsInvitacio() && !rt.EsSenseReserva();
		return ret;
	}

}
