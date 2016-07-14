package Domini.CasosUs.Gestors.Pistes;

import java.io.Serializable;

import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Calendaris.GestorCalendaris;
import Domini.Model.Calendari;
import Domini.Model.Pista;
import Factories.FactoriaControladors;

public class SelectorCalendariPista extends GestorCalendaris{

	protected int idPista;
	
	public SelectorCalendariPista(int idPista){
		this.idPista = idPista;
	}
	
	protected Pista getPista() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlPista().get(idPista);
	}
	@Override
	public void Select(Serializable id) throws Exception{
		Pista p = getPista();
		Calendari c = super.getCalendari(Integer.valueOf(id.toString()));
		p.setHorari(c);
		FactoriaControladors.getInstance().getCtrlPista().Update(p);
	}




}
