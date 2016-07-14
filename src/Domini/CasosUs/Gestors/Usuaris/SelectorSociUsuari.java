package Domini.CasosUs.Gestors.Usuaris;

import java.io.Serializable;

import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Socis.GestorSocis;
import Domini.Excepcions.UsuariJaSoci;
import Domini.Model.Soci;
import Domini.Model.Usuari;
import Domini.Model.UsuariSoci;
import Factories.FactoriaControladors;

public class SelectorSociUsuari extends GestorSocis{

	protected String correu;
	
	public SelectorSociUsuari(String correu){
		this.correu = correu;
	}

	private Usuari get() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlUsuari().get(correu);
	}
	@Override
	public void Select(Serializable id) throws Exception {
		Usuari usuari = get();
		Soci soci = FactoriaControladors.getInstance().getCtrlSoci().get(Integer.valueOf(id.toString()));
		if (usuari.EsSoci()) throw new UsuariJaSoci();
		else{
			UsuariSoci us = new UsuariSoci();
			us.setNom(usuari.getNom());
			us.setCognoms(usuari.getCognoms());
			us.setDni(usuari.getDni());
			us.setPass(usuari.getPass());
			us.setRang(usuari.getRang());
			us.setCorreu(usuari.getCorreu());
			us.setS(soci);
			
			FactoriaControladors.getInstance().getCtrlUsuari().Delete(usuari.getCorreu());
			FactoriaControladors.getInstance().getCtrlUsuari().Insert(us);
		}
	}
	
	

}
