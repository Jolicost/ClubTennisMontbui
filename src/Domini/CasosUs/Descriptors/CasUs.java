package Domini.CasosUs.Descriptors;

import Domini.CasosUs.Actors.Actor;
import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Controladors.ControladorDefecte;
import Domini.CasosUs.Descriptors.Gestors.CasUsGestor;
import Domini.CasosUs.Descriptors.Reservar.CasUsReservar;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.CasosUs.Resultats.Generals.ResultatDefecte;
import Domini.Excepcions.ActorInvalid;
import Domini.Excepcions.CasUsInvalid;
import Domini.MetaCasosUs.Recuperacio.CasUsRecuperacio;
import Domini.Model.Rang.FactoriaRangs;

public abstract class CasUs {

	protected ResultatCasUs resultat;
	protected Actor actor;
	
	public CasUs(){
		resultat = new ResultatDefecte();
	}
	
	public ResultatCasUs getResultat(){
		return resultat;
	}
	protected void setResultat(ResultatCasUs r){
		this.resultat = r;
	}

	public Gestor getGestorRoot() throws CasUsInvalid{
		throw new CasUsInvalid();
	}
	public CasUsGestor toGestor() throws CasUsInvalid{
		throw new CasUsInvalid();
	}
	public CasUsReservar toReservar() throws CasUsInvalid{
		throw new CasUsInvalid();
	}
	public CasUsRecuperacio toRecuperacio() throws CasUsInvalid{
		throw new CasUsInvalid();
	}
	public ControladorCasUs getControladorCasUs() throws ActorInvalid{
		return new ControladorDefecte();
	}
	
	public boolean SuficientPermis(){
		return actor.SuficientPermis(this);
	}
	
	public int getRang(){
		return FactoriaRangs.getInstance().getNormal().getPermis();
	}
	
	public boolean NomesSoci(){
		return false;
	}
	public void InitChild(CasUs cu) throws Exception{
		
	}
	
	public boolean IsRoot(){
		return false;
	}
	public boolean IsNeutral(){
		return false;
	}
	
	public void ferCasUs() throws Exception{
		throw new CasUsInvalid();
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	public boolean esRegistre(){
		return false;
	}
	
	public boolean EsSubmitRegistre(){
		return false;
	}
	

	
}
