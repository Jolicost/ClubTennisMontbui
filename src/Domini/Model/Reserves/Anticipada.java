package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoNomesSocis;
import Communicacio.Dades.Reserves.InfoReservaSoci;

public class Anticipada extends NomesSocis {

	@Override
	protected String getTipus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoNomesSocis();
	}
	
	public boolean EsAnticipada(){return true;}



}
