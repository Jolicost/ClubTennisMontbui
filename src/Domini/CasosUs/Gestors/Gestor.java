package Domini.CasosUs.Gestors;

import java.io.Serializable;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.GestorInvalid;

public abstract class Gestor {


	public Info Get() throws Exception{
		throw new GestorInvalid();
	}
	public Set<Info> getAll() throws Exception{
		throw new GestorInvalid();
	}
	public void Delete(Serializable id) throws Exception{
		throw new GestorInvalid();
	}
	public void Delete() throws Exception{
		throw new GestorInvalid();
	}
	
	public Gestor getIndividualUpdater(Serializable id) throws Exception{
		throw new GestorInvalid();
	}
	public Gestor getIndividualInserter() throws Exception{
		throw new GestorInvalid();
	}
	public Gestor getIndividualSelector(String entitat) throws Exception{
		throw new GestorInvalid();
	}
	public Gestor getCollectionManager(String entitat) throws Exception{
		throw new GestorInvalid();
	}
	public void Unassign(String entitat) throws Exception{
		throw new GestorInvalid();
	}
	public void Submit(Info i) throws Exception{
		throw new GestorInvalid();
	}
	public abstract String getEntitat() throws Exception;
	public abstract String getDescriptorGestor() throws Exception;
	
	public void Select(Serializable id) throws Exception{
		throw new GestorInvalid();
	}
	
	public GestorIndividual toGestorIndividual() throws GestorInvalid{
		throw new GestorInvalid();
	}

	
	
}
