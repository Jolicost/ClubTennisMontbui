package Dades.Controladors;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.InterficieBD.CtrlReservaSoci;
import Domini.Model.Reserves.ReservaSoci;

public class BDReservaSoci extends Controlador implements CtrlReservaSoci {


	@Override
	public void Update(ReservaSoci rs) throws BDExcepcio{
		super.Update(rs);
	}

	@Override
	public void Insert(ReservaSoci r) throws BDExcepcio{
		super.Insert(r);
	}

	@Override
	public ReservaSoci get(int idFranja) throws BDExcepcio {
		return (ReservaSoci) super.get(ReservaSoci.class, idFranja);
	}
	@Override
	public Set<ReservaSoci> getAll() throws BDExcepcio{
		return (Set<ReservaSoci>) (Set<?>) super.getAll(ReservaSoci.class);
	}


	

	
}
