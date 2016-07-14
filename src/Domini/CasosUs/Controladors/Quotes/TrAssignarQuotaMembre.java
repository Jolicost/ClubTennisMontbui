package Domini.CasosUs.Controladors.Quotes;

import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.SociNoTitular;
import Domini.Model.Soci;
import Domini.Model.Quotes.Membre;
import Domini.Model.Quotes.Quota;

public class TrAssignarQuotaMembre extends TrAssignarQuota {

	protected int titular;
	
	public int getTitular() {
		return titular;
	}
	public void setTitular(int titular) {
		this.titular = titular;
	}
	
	@Override
	protected Quota crearQuota() throws Exception {
		RestriccionsQuotaFamiliar r = new RestriccionsQuotaFamiliar(this.s);
		Soci t = super.getSoci(titular);
		
		if (!r.Test(t)) throw new QuotaInvalida();
		
		Membre m = new Membre();
		t.getQ().AfegirMembre(m);
		return m;
	}
	
	

}
