package Domini.CasosUs.Gestors;

import java.io.Serializable;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.GestorInvalid;

public abstract class GestorIndividual extends Gestor {

	public GestorIndividual(){}
	public abstract void Insert(Info i) throws Exception;
	public abstract void Update(Info i) throws Exception;
	public abstract void Delete() throws Exception;
	public abstract Info Get() throws Exception;
	public abstract void Submit(Info i) throws Exception;
	
	public Serializable getKey() throws GestorInvalid{
		throw new GestorInvalid();
	}
	public GestorIndividual toGestorIndividual() throws GestorInvalid{
		return this;
	}
}
