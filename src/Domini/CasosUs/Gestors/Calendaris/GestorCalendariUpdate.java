package Domini.CasosUs.Gestors.Calendaris;

import java.io.Serializable;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Communicacio.Excepcions.GestorInvalid;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Obertures.GestorObertures;
import Domini.Model.Calendari;
import Factories.FactoriaControladors;

public class GestorCalendariUpdate extends GestorCalendari {

	protected int idCalendari;
	public GestorCalendariUpdate(int idCalendari){
		this.idCalendari = idCalendari;
	}
	@Override
	public void Submit(Info i) throws Exception {
		super.Update(i);
	}
	@Override
	protected Calendari get() throws BDExcepcio {
		return FactoriaControladors.getInstance().getCtrlCalendari().get(idCalendari);
	}
	
	public String getDescriptorGestor() throws Exception{
		return FactoriaDescriptors.getInstance().getUpdate();
	}
	
	public Gestor getCollectionManager(String entitat) throws Exception{
		return new GestorObertures(this.idCalendari);
	}
	
	public Serializable getKey() throws GestorInvalid{
		return idCalendari;
	}
	

}
