package Domini.InterficieBD;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Reserves.ReservaSoci;

public interface CtrlReservaSoci {
	public void Update(ReservaSoci r) throws BDExcepcio;
	public void Insert(ReservaSoci r) throws BDExcepcio;
	public ReservaSoci get(int idFranja) throws BDExcepcio;
}
