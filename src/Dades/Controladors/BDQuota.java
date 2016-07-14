package Dades.Controladors;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlQuota;
import Domini.Model.Quotes.Quota;

public class BDQuota extends Controlador implements CtrlQuota {

	@Override
	public void Delete(int id) throws BDExcepcio {
		super.Delete(Quota.class, id);
	}

	@Override
	public void Insert(Quota q) throws BDExcepcio {
		super.Insert(q);
	}

	@Override
	public void Update(Quota q) throws BDExcepcio {
		super.Update(q);
	}

}
