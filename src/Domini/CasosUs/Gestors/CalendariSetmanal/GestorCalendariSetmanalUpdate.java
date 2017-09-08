package Domini.CasosUs.Gestors.CalendariSetmanal;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;

public abstract class GestorCalendariSetmanalUpdate extends GestorCalendariSetmanal {

	protected int idCalendari;
	public GestorCalendariSetmanalUpdate(int id){
		this.idCalendari = id;
	}


	@Override
	public void Submit(Info i) throws Exception {
		super.Update(i);
	}

	@Override
	public String getDescriptorGestor() throws Exception {
		return FactoriaDescriptors.getInstance().getUpdate();
	}

}
