package Domini.CasosUs.Gestors.Accions;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Gestors.GestorIndividualAccio;

public class AccioUpdate extends Accio{

	public void CallGestor(GestorIndividualAccio gi,Info i) throws Exception{
		gi.Update(i);
	}
	
	public String getDescriptorGestor() throws Exception{
		return FactoriaDescriptors.getInstance().getUpdate();
	}
}
