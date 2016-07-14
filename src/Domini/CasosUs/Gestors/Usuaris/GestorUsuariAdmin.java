package Domini.CasosUs.Gestors.Usuaris;

import Communicacio.Dades.InfoUsuari;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Accions.Accio;
import Domini.Excepcions.UsuariNoSoci;
import Domini.Model.Usuari;
import Domini.Model.UsuariSoci;
import Domini.Model.Rang.FactoriaRangs;
import Domini.Model.Rang.Rang;
import Domini.Model.Rang.RangInvalid;
import Factories.FactoriaControladors;

public class GestorUsuariAdmin extends GestorUsuari {
	
	public GestorUsuariAdmin(String correu,Accio accio) {
		super(correu,accio);
	}



	public GestorUsuariAdmin(Accio accio) {
		super(accio);
	}



	protected void editar(InfoUsuari u,Usuari us) throws BDExcepcio, RangInvalid {
		if (u.getEmail() != null) us.setCorreu(u.getEmail());
		if (u.getPassword() != null && u.getPassword().length() > 0) us.setPass(u.getPassword());
		if (u.getRang() != null) us.setRangOriginal(FactoriaRangs.getInstance().getRang(u.getRang()));
		if (u.getNom() != null) us.setNom(u.getNom());
		if (u.getCognoms() != null) us.setCognoms(u.getCognoms());
		if (u.getDni() != null) us.setDni(u.getDni());
	}

	@Override
	protected void PopulateInsert(InfoUsuari i,Usuari u) throws RangInvalid {
		u.setRangOriginal(FactoriaRangs.getInstance().getRang(i.getRang()));
	}
	
	public void Unassign(String entitat) throws Exception{
		Usuari usuari = get();
		if (usuari.EsSoci()){
			UsuariSoci uu = usuari.toUsuariSoci();
			Usuari us = new Usuari();
			us.setCorreu(usuari.getCorreu());
			us.setNom(usuari.getNom());
			us.setCognoms(usuari.getCognoms());
			us.setDni(usuari.getDni());
			us.setPass(usuari.getPass());
			us.setRang(usuari.getRang());
			
			FactoriaControladors.getInstance().getCtrlUsuariSoci().Delete(uu);
			FactoriaControladors.getInstance().getCtrlUsuari().Insert(us);
		}
		else throw new UsuariNoSoci();
	}
	
	@Override
	public Gestor getIndividualSelector(String entitat) throws Exception {
		return new SelectorSociUsuari(this.id);
	}
	









	
	

}
