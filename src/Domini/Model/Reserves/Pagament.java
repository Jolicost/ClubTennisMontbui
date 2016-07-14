package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoPagament;
import Communicacio.Dades.Reserves.InfoReservaSoci;

public class Pagament extends ReservaSoci {

	@Override
	protected String getTipus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoPagament();
	}

}
