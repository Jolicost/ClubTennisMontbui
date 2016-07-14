package Domini.CasosUs.Gestors.Pistes;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.GestorInvalid;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Gestors.GestorIndividual;
import Domini.Model.Pista;
import Factories.FactoriaControladors;

public abstract class GestorPista extends GestorIndividual{

	public GestorPista(){
		super();
	}

	@Override
	public void Insert(Info i) throws Exception {
		throw new GestorInvalid();
	}

	@Override
	public void Update(Info i) throws Exception {
		throw new GestorInvalid();
	}

	@Override
	public void Delete() throws Exception {
		throw new GestorInvalid();
	}

	@Override
	public Info Get() throws Exception {
		throw new GestorInvalid();
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getPista();
	}


}
