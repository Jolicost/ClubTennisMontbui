package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoReservaRanking;
import Communicacio.Dades.Reserves.InfoReservaSoci;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class ReservaRanking extends NomesSocis {

	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoReservaRanking();
	}

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getRanking().getNom();
	}
	
	public boolean EsRanking(){return true;}

}
