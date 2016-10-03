package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoNomesSocis;
import Communicacio.Dades.Reserves.InfoReservaSoci;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class Anticipada extends NomesSocis {

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getNomesSocis().getNom();
	}

	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoNomesSocis();
	}
	
	public boolean EsAnticipada(){return true;}



}
