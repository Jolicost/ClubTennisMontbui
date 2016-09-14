package Domini.Model.Restriccions;

import java.util.function.Predicate;

import org.joda.time.Duration;
import org.joda.time.Interval;

import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;

public class RestriccioInvitacio extends RestriccioAnticipada {

	public RestriccioInvitacio(Soci s,Pista p) {
		super(s,p);
	}

	@Override
	protected int getTimeKey(Interval i) {
		return i.getStart().getMonthOfYear();
	}

	@Override
	protected Interval getIntervalPertanyent(Interval i) {
		return new Interval(i.getStart().dayOfMonth().withMinimumValue().millisOfDay().withMinimumValue(),
							i.getStart().dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue());
	}

	@Override
	protected int getLimit() {
		return s.getMaxInvitacionsMes();
	}

	@Override
	protected Predicate<ReservaSoci> createPredicate() {
		Predicate<ReservaSoci> ret = rs -> rs.EsInvitacio();
		return ret;
	}



}
