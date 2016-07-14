package Domini.CasosUs.Gestors;

import java.io.Serializable;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;

public abstract class GestorColectiu extends Gestor {

	public abstract Set<Info> getAll() throws Exception;
	
	public abstract void Delete(Serializable id) throws Exception;
	
	public abstract Gestor getIndividualUpdater(Serializable id) throws Exception;
	
	public abstract Gestor getIndividualInserter() throws Exception;
	
	public abstract String getEntitat() throws Exception;
	

	public String getDescriptorGestor() throws Exception{
		return FactoriaDescriptors.getInstance().getCRUD();
	}

}
