package Domini.CasosUs.Descriptors.Generals;

import org.joda.time.DateTime;

import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Gestors.Franges.GestorFrangesTotal;
import Domini.CasosUs.Resultats.Generals.ResultatFrangesPubliques;
import Domini.Model.Rang.FactoriaRangs;

public class CasUsConsultarReservesPubliques extends CasUs {


	@Override
	public void ferCasUs() throws Exception {
		GestorFrangesTotal t = new GestorFrangesTotal();
		DateTime n = DateTime.now();
		super.resultat = new ResultatFrangesPubliques(t.getAllInterval(n,n.plusWeeks(1)));
	}

	@Override
	public int getRang() {
		return FactoriaRangs.getInstance().getNormal().getPermis();
	}

	@Override
	public boolean IsRoot() {
		return true;
	}

}
