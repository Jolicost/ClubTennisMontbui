package Domini.CasosUs.Gestors.Socis;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.DadaIncorrecta;
import Communicacio.Excepcions.GestorInvalid;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.GestorIndividual;
import Domini.CasosUs.Gestors.Accions.Accio;
import Domini.Model.Soci;
import Factories.FactoriaControladors;

public abstract class GestorSoci extends GestorIndividual {


	public GestorSoci() {

	}

	protected abstract Soci get() throws BDExcepcio;
	
	public Soci getSoci() throws BDExcepcio{
		return get();
	}

	@Override
	public void Insert(Info i) throws Exception {
		Soci s = get();
		populate(i,s);
		
		
		FactoriaControladors.getInstance().getCtrlSoci().Insert(s);
		FactoriaControladors.getInstance().getCtrlQuota().Insert(s.getQ());
	}

	@Override
	public void Update(Info i) throws Exception {
		Soci s = get();
		populate(i,s);
		FactoriaControladors.getInstance().getCtrlSoci().Update(s);
	}

	@Override
	public void Delete() throws Exception {
		throw new GestorInvalid();
	}

	@Override
	public Info Get() throws Exception {
		throw new GestorInvalid();
	}

	private void populate(Info i,Soci s) throws DadaIncorrecta{
		s.Populate(i.toInfoSoci());
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getSoci();
	}


}
