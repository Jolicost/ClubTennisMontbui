package Domini.CasosUs.Controladors.Quotes;

import Domini.CasosUs.Controladors.Reserva.EstatInvalid;
import Domini.CasosUs.Resultats.ResultatEntitat;

public abstract class EstatAssignarQuota {

	protected int IDSoci;
	protected EstatAssignarQuota seguent;
	
	public EstatAssignarQuota(int IDSoci){
		this.IDSoci = IDSoci;
	}
	
	public ResultatEntitat SeleccionarQuota(String tipus) throws Exception{
		throw new EstatInvalid();
	}
	
	public ResultatEntitat SeleccionarTitular(int IDSoci) throws Exception{
		throw new EstatInvalid();
	}

	public EstatAssignarQuota getSeguent() {
		return seguent;
	}

	public void setSeguent(EstatAssignarQuota seguent) {
		this.seguent = seguent;
	}
	
}
