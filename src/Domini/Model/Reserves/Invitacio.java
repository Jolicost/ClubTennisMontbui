package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoInvitacio;
import Communicacio.Dades.Reserves.InfoReservaSoci;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class Invitacio extends ReservaSoci {
	public boolean EsInvitacio(){return true;}

	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getInvitacio().getNom();
	}

	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoInvitacio();
	}
}
