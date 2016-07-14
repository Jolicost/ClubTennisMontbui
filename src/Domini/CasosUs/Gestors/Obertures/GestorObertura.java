package Domini.CasosUs.Gestors.Obertures;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoObertura;
import Communicacio.Excepcions.GestorInvalid;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.GestorIndividual;
import Domini.Model.Calendari;
import Factories.FactoriaControladors;

public abstract class GestorObertura extends GestorIndividual{

	protected int idCalendari;
	
	
	public GestorObertura(int idCalendari){
		this.idCalendari = idCalendari;
	}


	protected Calendari getCalendari() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlCalendari().get(idCalendari);
	}
	@Override
	public void Delete() throws Exception {

	}
	@Override
	public void Insert(Info i) throws Exception {
		throw new GestorInvalid();
	}

	@Override
	public void Update(Info i) throws Exception {
		throw new GestorInvalid();
	}

	@Override
	public Info Get() throws Exception {
		throw new GestorInvalid();
	}
	

	
	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getObertura();
	}


}
