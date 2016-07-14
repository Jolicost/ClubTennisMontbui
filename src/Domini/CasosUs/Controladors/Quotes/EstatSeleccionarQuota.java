package Domini.CasosUs.Controladors.Quotes;

import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Controladors.Reserva.EstatInvalid;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatEscriptura;
import Domini.CasosUs.Resultats.Generals.ResultatSeleccionarEntitat;
import Domini.Model.Soci;
import Factories.FactoriaControladors;

public class EstatSeleccionarQuota extends EstatAssignarQuota {

	public EstatSeleccionarQuota(int IDSoci) {
		super(IDSoci);
	}

	public ResultatEntitat SeleccionarQuota(String tipus) throws Exception{
		switch (tipus){
		case("titular"):{
			TrAssignarQuota tr = new TrAssignarQuotaTitular();
			tr.setIDSoci(IDSoci);
			tr.Executar();
			return new ResultatEscriptura();
		}
		case("membre"):{
			Soci s = FactoriaControladors.getInstance().getCtrlSoci().get(IDSoci);
			RestriccionsQuotaFamiliar r = new RestriccionsQuotaFamiliar(s);
			Set<Info> ret = new HashSet<>();
			r.getAll().forEach(so -> ret.add(so.toInfo()));
			ResultatSeleccionarEntitat ra = new ResultatSeleccionarEntitat(ret);
			ra.setEntitat(FactoriaEntitats.getInstance().getSoci());
			ra.setDescriptorGestor(FactoriaDescriptors.getInstance().getSelect());
			
			super.setSeguent(new EstatSeleccionarTitular(IDSoci));
			return ra;
		}
		case("individual"):{
			TrAssignarQuota tr = new TrAssignarQuotaIndividual();
			tr.setIDSoci(IDSoci);
			tr.Executar();
			return new ResultatEscriptura();
		}
		default: throw new QuotaInvalida();
		}
	}
}
