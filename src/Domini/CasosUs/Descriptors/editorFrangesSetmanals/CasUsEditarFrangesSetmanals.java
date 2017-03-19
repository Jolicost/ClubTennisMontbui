package Domini.CasosUs.Descriptors.editorFrangesSetmanals;

import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Controladors.FrangesSetmanals.ControladorFrangesSetmanals;
import Domini.CasosUs.Controladors.FrangesSetmanals.IControladorFrangesSetmanals;
import Domini.CasosUs.Resultats.ResultatConjunt;
import Domini.CasosUs.Resultats.FrangesSetmanals.ResultatFrangesSetmanals;
import Domini.Excepcions.ActorInvalid;

public class CasUsEditarFrangesSetmanals extends CasUsFrangesSetmanals {

	protected int IDCalendari;
	
	public CasUsEditarFrangesSetmanals(int IDCalendari){
		this.IDCalendari = IDCalendari;
	}


	@Override
	public ControladorCasUs getControladorCasUs() throws ActorInvalid {
		return new ControladorFrangesSetmanals(super.getActor(),IDCalendari);
	}


	@Override
	public void cridarControlador(IControladorFrangesSetmanals c) throws Exception {
		ResultatConjunt ret = new ResultatFrangesSetmanals();
		Set<Info> taula = new HashSet<>();
		c.getAll().forEach(i -> taula.add(i));
		ret.setConjunt(taula);
		super.setResultat(ret);
	}


	@Override
	public boolean IsRoot() {
		return true;
	}
}
