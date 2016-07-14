package Domini.CasosUs.Gestors.Accions;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.CasosUs.Gestors.GestorIndividual;
import Domini.CasosUs.Gestors.GestorIndividualAccio;

public abstract class Accio {

	public void CallGestor(GestorIndividualAccio gi)throws Exception{}
	public void CallGestor(GestorIndividualAccio gi,Info i) throws Exception{}
	public abstract String getDescriptorGestor() throws Exception;
}
