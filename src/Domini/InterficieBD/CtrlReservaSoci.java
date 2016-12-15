package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Reserves.ReservaSoci;

public interface CtrlReservaSoci {
	public void Update(ReservaSoci r) throws BDExcepcio;
	public void Insert(ReservaSoci r) throws BDExcepcio;
	public ReservaSoci get(int idFranja) throws BDExcepcio;
	public Set<ReservaSoci> getAll() throws BDExcepcio;
}
