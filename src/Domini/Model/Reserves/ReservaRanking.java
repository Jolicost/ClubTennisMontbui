package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoReservaRanking;
import Communicacio.Dades.Reserves.InfoReservaSoci;

public class ReservaRanking extends NomesSocis {

	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoReservaRanking();
	}

	@Override
	protected String getTipus() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean EsRanking(){return true;}

}
