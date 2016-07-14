package Dades.Controladors;

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


	

	
}
