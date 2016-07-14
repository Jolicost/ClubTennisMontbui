package Domini.CasosUs.Controladors.Quotes;

import java.io.Serializable;

import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.CasosUs.Resultats.ResultatEntitat;

public class ControladorSeleccionarQuota extends Gestor{

	private int IDSoci;
	
	private EstatAssignarQuota estat;
	
	public ControladorSeleccionarQuota(int IDSoci){
		this.IDSoci = IDSoci;
		estat = new EstatSeleccionarQuota(IDSoci);
	}
	
	public ResultatEntitat SeleccionarQuota(String tipus) throws Exception{
		ResultatEntitat ret =  estat.SeleccionarQuota(tipus);
		estat = estat.getSeguent();
		return ret;
	}
	
	public ResultatEntitat TriarSoci(int ID) throws Exception{
		ResultatEntitat ret = estat.SeleccionarTitular(ID);
		estat = estat.getSeguent();
		return ret;
	}

	@Override
	public String getEntitat() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescriptorGestor() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Select(Serializable id) throws Exception {
		TriarSoci(Integer.valueOf(id.toString()));
	}
}
