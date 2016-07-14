package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoInvitacio;
import Communicacio.Dades.Reserves.InfoReservaSoci;

public class Invitacio extends ReservaSoci {
	public boolean EsInvitacio(){return true;}

	@Override
	protected String getTipus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoInvitacio();
	}
}
