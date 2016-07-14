package Communicacio.Dades.Reserves.Confirmar;

public abstract class InfoConfirmarLimitada extends InfoConfirmarReserva{

	public InfoConfirmarLimitada() {
		super();
	}

	private int quotaActual;

	public int getQuotaActual() {
		return quotaActual;
	}

	public void setQuotaActual(int quotaActual) {
		this.quotaActual = quotaActual;
	}
	
}
