package Domini.CasosUs.Gestors.Socis;

import java.io.Serializable;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Communicacio.Excepcions.GestorInvalid;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;
import Factories.FactoriaControladors;

public class GestorSociUpdate extends GestorSoci{

	private int numero;
	public GestorSociUpdate(int numero){
		this.numero = numero;
	}
	@Override
	protected Soci get() throws BDExcepcio {
		return FactoriaControladors.getInstance().getCtrlSoci().get(numero);
	}

	@Override
	public void Submit(Info i) throws Exception {
		super.Update(i);
	}
	
	@Override
	public Info Get() throws Exception {
		return get().toInfo();
	}
	
	public String getDescriptorGestor() throws Exception{
		return FactoriaDescriptors.getInstance().getUpdate();
	}
	
	public Serializable getKey() throws GestorInvalid{
		return numero;
	}

}
