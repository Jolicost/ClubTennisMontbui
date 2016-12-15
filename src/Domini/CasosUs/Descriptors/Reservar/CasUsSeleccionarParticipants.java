package Domini.CasosUs.Descriptors.Reservar;

import java.util.Set;

import Domini.CasosUs.Controladors.Reserva.FerReserva;

public class CasUsSeleccionarParticipants extends CasUsReservar {

	private Set<Integer> participants;

	public CasUsSeleccionarParticipants(Set<Integer> participants){
		this.participants = participants;
	}
	@Override
	protected void CridarCasUs(FerReserva main) throws Exception {
		main.SeleccionarParticipants(participants);
	}
	
	
}
