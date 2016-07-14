package Domini.CasosUs.Gestors.Calendaris;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Calendari;

public class GestorCalendariInsert extends GestorCalendari{

	@Override
	protected Calendari get() throws BDExcepcio {
		return new Calendari();
	}

	@Override
	public void Submit(Info i) throws Exception {
		super.Insert(i);
	}
	
	public String getDescriptorGestor() throws Exception{
		return FactoriaDescriptors.getInstance().getInsert();
	}

}
