package Domini.InterficieBD;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Quotes.Quota;

public interface CtrlQuota {
	public void Delete(int id) throws BDExcepcio;
	public void Insert(Quota q) throws BDExcepcio;
	public void Update(Quota q) throws BDExcepcio;
}
