package Domini.CasosUs.Gestors.Calendaris;

import Communicacio.Dades.Info;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.GestorIndividual;
import Domini.Model.Calendari;
import Factories.FactoriaControladors;

public abstract class GestorCalendari extends GestorIndividual {

	
	public GestorCalendari() {
		super();
	}
	
	protected abstract Calendari get() throws BDExcepcio;


	@Override
	public void Insert(Info i) throws Exception {
		Calendari c = get();
		c.Populate(i.toInfoCalendari());
		FactoriaControladors.getInstance().getCtrlCalendari().Insert(c);
	}

	@Override
	public void Update(Info i) throws Exception {
		Calendari c = get();
		c.Populate(i.toInfoCalendari());
		FactoriaControladors.getInstance().getCtrlCalendari().Update(c);
	}

	@Override
	public void Delete() throws Exception {
		Calendari c = get();
		FactoriaControladors.getInstance().getCtrlCalendari().Delete(c);
	}

	public String getEntitat() throws Exception{
		return FactoriaEntitats.getInstance().getCalendari();
	}
	
	
	@Override
	public Info Get() throws Exception {
		return get().toInfo();
	}
	
	public Calendari getCalendari() throws BDExcepcio{
		return get();
	}




}
