package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoPagament;
import Communicacio.Dades.Reserves.InfoReservaSoci;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class Pagament extends ReservaSoci {

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getPagament().getNom();
	}

	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoPagament();
	}
	
	public boolean EsPagament(){return true;}

}
