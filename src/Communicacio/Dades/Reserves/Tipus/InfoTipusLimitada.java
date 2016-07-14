package Communicacio.Dades.Reserves.Tipus;

public abstract class InfoTipusLimitada extends InfoTipusReserva{

	public InfoTipusLimitada() {
		super();
	}

	private int restants;

	public int getRestants() {
		return restants;
	}

	public void setRestants(int restants) {
		this.restants = restants;
	}
}
