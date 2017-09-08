package Domini.CasosUs.Gestors.CalendariSetmanal;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.GestorInvalid;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.GestorIndividual;
import Domini.Model.Calendaris.CalendariSetmanal;
import Factories.FactoriaControladors;

public abstract class GestorCalendariSetmanal extends GestorIndividual {

	@Override
	public void Insert(Info i) throws Exception {
		CalendariSetmanal c = get();
		c.populate(i.toInfoCalendariSetmanal());
		FactoriaControladors.getInstance().getCtrlCalendariSetmanal().Insert(c);
	}

	@Override
	public void Update(Info i) throws Exception {
		CalendariSetmanal c = get();
		c.populate(i.toInfoCalendariSetmanal());
		FactoriaControladors.getInstance().getCtrlCalendariSetmanal().Update(c);
	}

	@Override
	public void Delete() throws Exception {
		throw new GestorInvalid();
	}

	@Override
	public Info Get() throws Exception {
		return get().toInfo();
	}


	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getCalendariSetmanal();
	}
	
	protected abstract CalendariSetmanal get() throws BDExcepcio;

}
