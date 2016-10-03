package Domini.CasosUs.Gestors.Franges;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.GestorInvalid;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Accions.Accio;
import Domini.Model.Reserves.Franja;
import Domini.Model.Reserves.Reserva;
import Factories.FactoriaControladors;

public class GestorReserva extends GestorFranja {

	public GestorReserva(Accio accio) {
		super(accio);
	}
	
	public GestorReserva(Accio accio,int IDFranja){
		super(accio,IDFranja);
	}
	
	protected Reserva getReserva() throws BDExcepcio{
		//TODO CANVIAR CONTROLADOR A RESERVA PURA
		return FactoriaControladors.getInstance().getCtrlReservaSoci().get(super.idFranja);
	}

	@Override
	protected Franja crearFranja(Info i) throws Exception {
		throw new GestorInvalid();
	}

	@Override
	protected Franja editarFranja(Info i) throws Exception {
		Reserva r = getReserva();
		r.Populate(i.toInfoReserva());
		return r;
	}

	@Override
	public void Delete() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getReserva();
	}

}
