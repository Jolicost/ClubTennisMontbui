package Domini.CasosUs.Gestors.Usuaris;

import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoUsuari;
import Communicacio.Excepcions.InsuficientPermis;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.GestorIndividualAccio;
import Domini.CasosUs.Gestors.Accions.Accio;
import Domini.Excepcions.SociJaAssignat;
import Domini.Model.Soci;
import Domini.Model.Usuari;
import Domini.Model.Rang.RangInvalid;
import Factories.FactoriaControladors;

public abstract class GestorUsuari extends GestorIndividualAccio {
	protected String id;
	
	
	public GestorUsuari(String correu,Accio accio){
		super(accio);
		this.id = correu;
		
	}
	
	public GestorUsuari(Accio accio){
		super(accio);
	}
	
	protected Usuari get() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlUsuari().get(id);
	}
	
	public Usuari getUsuari() throws BDExcepcio{return get();}
	
	@Override
	public void Insert(Info i) throws Exception {
		Usuari u = new Usuari();
		InfoUsuari iu = i.toInfoUsuari();
		u.setCognoms(iu.getCognoms());
		u.setNom(iu.getNom());
		u.setDni(iu.getDni());
		u.setCorreu(iu.getEmail());
		u.setPass(iu.getPassword());
		PopulateInsert(iu,u);
		FactoriaControladors.getInstance().getCtrlUsuari().Insert(u);
		
		BuscarSoci(u);
	}
	
	protected abstract void PopulateInsert(InfoUsuari i,Usuari u) throws RangInvalid;

	@Override
	public void Delete() throws Exception {
		FactoriaControladors.getInstance().getCtrlUsuari().Delete(id);
	}
	@Override
	public Info Get() throws BDExcepcio {
		return get().toInfo();
	}
	
	public void Update(Info i) throws Exception{
		Usuari u = get();
		editar(i.toInfoUsuari(),u);
		FactoriaControladors.getInstance().getCtrlUsuari().Update(u);
	}
	
	protected abstract void editar(InfoUsuari u,Usuari us) throws Exception;

	
	
	@Override
	public void Unassign(String entitat) throws Exception {
		throw new InsuficientPermis();
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getUsuari();
	}
	
	protected void BuscarSoci(Usuari u) throws Exception{
		Set<Soci> socis = FactoriaControladors.getInstance().getCtrlSoci().getAll();
		for (Soci s : socis){
			if (s.MateixDni(u.getDni())){
				ComprovarUnicitatUsuari(u.getDni());
				SelectorSociUsuari sl = new SelectorSociUsuari(u.getCorreu());
				sl.Select(s.getNumero());
			}
		}
	}
	
	protected void ComprovarUnicitatUsuari(String dni) throws SociJaAssignat,BDExcepcio{
		
	}
	
	

	
	
}
