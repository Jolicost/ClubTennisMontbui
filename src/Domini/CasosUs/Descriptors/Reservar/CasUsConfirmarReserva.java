package Domini.CasosUs.Descriptors.Reservar;

import Domini.CasosUs.Controladors.Reserva.FerReserva;

public class CasUsConfirmarReserva extends CasUsReservar{



	@Override
	protected void CridarCasUs(FerReserva main) throws Exception {
		main.Confirmar();
	}

}
