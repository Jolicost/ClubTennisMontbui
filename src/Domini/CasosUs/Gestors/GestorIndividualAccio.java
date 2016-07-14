package Domini.CasosUs.Gestors;

import Communicacio.Dades.Info;
import Domini.CasosUs.Gestors.Accions.Accio;

public abstract class GestorIndividualAccio extends GestorIndividual {

	protected Accio accio;
	public GestorIndividualAccio(Accio accio){
		this.accio = accio;
	}
	
	public void Submit(Info i) throws Exception{
		accio.CallGestor(this, i);
	}
	
	public String getDescriptorGestor() throws Exception{
		return accio.getDescriptorGestor();
	}

}
