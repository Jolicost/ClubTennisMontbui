package Domini.CasosUs.Sessio;

import Communicacio.Excepcions.InsuficientPermis;
import Domini.CasosUs.Actors.Actor;
import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Controladors.ControladorDefecte;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.ResultatCasUs;

public class CasUsSessio {

	protected ControladorCasUs controlador;
	protected Actor actor;
	
	public CasUsSessio(Actor actor){
		controlador = getControladorDefecte();
		this.actor = actor;
		
	}

	public ResultatCasUs FerCasDUs(CasUs cu) throws Exception{
		cu.setActor(actor);
		if (!cu.SuficientPermis()) throw new InsuficientPermis();
		
		if (cu.IsRoot()) controlador = cu.getControladorCasUs();
		return controlador.FerCasDUs(cu);

	}
	
	public ResultatCasUs FerCasDUsIndividual(CasUs cu) throws Exception{
		cu.setActor(actor);
		if (!cu.SuficientPermis()) throw new InsuficientPermis();
		cu.ferCasUs();
		return cu.getResultat();
	}
	
	public String getEntitatGestor() throws Exception {
		return controlador.getEntitatGestor();
	}
	
	protected boolean suficientPermis(CasUs cu){
		return true;
	}
	
	protected void setControlador(ControladorCasUs c){
		this.controlador = c;
	}	
	
	protected  ControladorCasUs getControladorDefecte(){
		return new ControladorDefecte();
	}
	public String ObtenirRol(){
		return actor.getRol();
	}
	
	
	


	
	
	
	
}
