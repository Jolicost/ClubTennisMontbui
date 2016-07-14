package Domini.CasosUs.Gestors.Socis;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;

public class GestorSociInsert extends GestorSoci {

	@Override
	protected Soci get() throws BDExcepcio {
		return new Soci();
	}

	@Override
	public void Submit(Info i) throws Exception {
		super.Insert(i);
	}

	@Override
	public String getDescriptorGestor() throws Exception {
		return FactoriaDescriptors.getInstance().getInsert();
	}

}
