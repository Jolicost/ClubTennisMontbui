package Domini.CasosUs.Actors;

import Communicacio.Dades.Accions.InfoAccions;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.Excepcions.ActorInvalid;
import Domini.MetaCasosUs.Accions.TrConsultarAccions;
import Domini.MetaCasosUs.Accions.TrConsultarAccionsRang;

public abstract class Actor {

	
	public Registrat getRegistrat() throws ActorInvalid{
		throw new ActorInvalid();
	}
	
	public Soci getSoci() throws ActorInvalid{
		throw new ActorInvalid();
	}
	
	
	public boolean SuficientPermis(CasUs cu){
		boolean s = true;
		if (cu.NomesSoci()){
			s = this.EsSoci();
		}
		return (cu.getRang() <= getRang() && s);
	}
	
	protected abstract int getRang();
	
	public abstract String getRol();
	
	public InfoAccions getInfoAccions(){
		InfoAccions ret = new InfoAccions();
		TrConsultarAccions membre = getAccionsMembre();
		ret.setAccions(membre.consultarAccions());
		
		TrConsultarAccionsRang rang = new TrConsultarAccionsRang(this.getRang());
		ret.getAccions().addAll(rang.consultarAccions());
		
		return ret;
	}
	
	protected abstract TrConsultarAccions getAccionsMembre();

	public InfoAccions getInfoAccionsUsuari() {
		TrConsultarAccions u = getAccionsMembre();
		InfoAccions ret = new InfoAccions();
		ret.setAccions(u.consultarAccionsUsuari());
		return ret;		
	}
	
	protected boolean EsSoci(){
		return false;
	}

	
	
}
