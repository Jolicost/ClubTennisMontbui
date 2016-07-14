package Domini.CasosUs.Controladors.Reserva;

import Domini.CasosUs.Actors.Actor;
import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Descriptors.Reservar.CasUsReservar;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.Excepcions.ActorInvalid;

public class ControladorReserves extends ControladorCasUs {

	
	protected FerReserva casus;
	public ControladorReserves(Actor actor) throws ActorInvalid{
		casus = new FerReserva(actor.getSoci());
	}
	@Override
	public ResultatCasUs FerCasDUs(CasUs cu) throws Exception {
		CasUsReservar cur = cu.toReservar();
		cur.FerCasUs(casus);
		ResultatCasUs ret = cur.getResultat();
		casus.SeguentEstat();
		return ret;
	}

	



}
