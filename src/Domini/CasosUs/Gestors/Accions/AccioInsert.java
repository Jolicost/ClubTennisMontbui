package Domini.CasosUs.Gestors.Accions;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Gestors.GestorIndividualAccio;

public class AccioInsert extends Accio {


	
	public void CallGestor(GestorIndividualAccio gi,Info i) throws Exception{
		gi.Insert(i);
	}

	@Override
	public String getDescriptorGestor() throws Exception {
		return FactoriaDescriptors.getInstance().getInsert();
	}

}
