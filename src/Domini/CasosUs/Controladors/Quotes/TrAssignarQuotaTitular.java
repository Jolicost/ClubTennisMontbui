package Domini.CasosUs.Controladors.Quotes;

import Domini.Model.Quotes.Quota;
import Domini.Model.Quotes.Titular;

public class TrAssignarQuotaTitular extends TrAssignarQuotaSola {

	@Override
	protected Quota crearQuota() {
		Titular i = new Titular();
		return i;
	}

}
