package Domini.CasosUs.Descriptors.Gestors;

import Communicacio.Excepcions.GestorInvalid;
import Communicacio.Xarxa.Domini.Entitats.Entitat;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Descriptors.CasUsDada;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Controlador.CuaCasosUs;
import Domini.CasosUs.Gestors.Controlador.CuaGestors;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.Excepcions.CasUsInvalid;
import Domini.Model.Rang.FactoriaRangs;

public abstract class CasUsGestor extends CasUsDada {

	public CasUsGestor(String entitat) {
		super();
		this.entitat = entitat;
	}

	public CasUsGestor(){
		super();
	}
	protected String entitat;
	protected Gestor gestor;
	
	


	public void setEntitat(String entitat) {
		this.entitat = entitat;
	}

	public String getEntitat() {
		return entitat;
	}
	
	public void InitChild(CasUs cu) throws Exception{
		CasUsGestor cus = cu.toGestor();
		Gestor g = cus.getChild(this.getGestor());
		cus.setEntitat(g.getEntitat());
		cus.setGestor(g);
	}
	
	
	
	public Gestor getChild(Gestor g) throws Exception{
		throw new CasUsInvalid();
	}
	
	public CasUsGestor toGestor() throws CasUsInvalid{
		return this;
	}
	
	
	public void ferCasUs() throws Exception{
		ResultatEntitat r = RealitzarCasUs();
		r.setEntitat(this.getEntitat());
		r.setDescriptorGestor(this.getDescriptorGestor());
		this.setResultat(r);
	}
	
	protected abstract ResultatEntitat RealitzarCasUs() throws Exception;

	protected abstract String getDescriptorGestor();
	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}
	
	public int getRang(){
		return FactoriaRangs.getInstance().getMonitor().getPermis();
	}
}
