package Domini.CasosUs.Controladors.Quotes;

import Domini.Model.Quotes.Individual;
import Domini.Model.Quotes.Quota;

public class TrAssignarQuotaIndividual extends TrAssignarQuotaSola{

	@Override
	protected Quota crearQuota() {
		Individual i = new Individual();
		return i;
	}

}
