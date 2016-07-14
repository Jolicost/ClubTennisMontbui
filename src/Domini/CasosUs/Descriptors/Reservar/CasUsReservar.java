package Domini.CasosUs.Descriptors.Reservar;

import Domini.CasosUs.Controladors.Reserva.FerReserva;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.Excepcions.CasUsInvalid;

public abstract class CasUsReservar extends CasUs {

	
	
	public CasUsReservar toReservar() throws CasUsInvalid{
		return this;
	}
	
	public void FerCasUs(FerReserva main) throws Exception{
		CridarCasUs(main);
		
		this.resultat = main.getResultat();
	}
	
	protected abstract void CridarCasUs(FerReserva main) throws Exception;
	
	public boolean NomesSoci(){
		return true;
	}

}
