package Mail.Informacio;

import Communicacio.Dades.Reserves.Correus.InfoReservaRealitzada;

public class ReservaRealitzadaMail extends InformacioMail {

	private static String correu = InformacioMail.acc;
	private InfoReservaRealitzada reserva;
	public ReservaRealitzadaMail(InfoReservaRealitzada ir) {
		super(correu);
		this.reserva = ir;
	}
	@Override
	protected String getSubject() {
		return "Reserva realitzada: " + reserva.getIdFranja();
	}
	@Override
	protected String getMsg() {
		return "Reserva realitzada: \n" +
				"Soci nº: " + reserva.getNumero() + "\n" +
				"Nom: " + reserva.getNom() + " " + reserva.getCognoms() + ".\n" +
				"Data: " + reserva.getDiaFormat() + "\n" +
				"Hora: " + reserva.getIniciFormat() + "-" + reserva.getFiFormat() + "\n" +
				"Esport: " + reserva.getEsport() + "\n" +
				"Nom Pista: " + reserva.getNomPista() + "\n" +
				"Tipus: " + reserva.getTipus();
 	}

}
