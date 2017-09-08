package Domini.CasosUs.Gestors.CalendariSetmanal;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Calendaris.CalendariSetmanal;

public abstract class GestorCalendariSetmanalInsert extends GestorCalendariSetmanal{

	@Override
	protected abstract CalendariSetmanal get() throws BDExcepcio;

	@Override
	public void Submit(Info i) throws Exception {
		super.Insert(i);
	}

	@Override
	public String getDescriptorGestor() throws Exception {
		return FactoriaDescriptors.getInstance().getInsert();
	}

}
