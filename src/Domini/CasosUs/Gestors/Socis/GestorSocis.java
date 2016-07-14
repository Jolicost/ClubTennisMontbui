package Domini.CasosUs.Gestors.Socis;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Info;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.Model.Usuari;
import Domini.Model.UsuariSoci;
import Factories.FactoriaControladors;

public class GestorSocis extends GestorColectiu {

	


	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		FactoriaControladors.getInstance().getCtrlSoci().getAll().forEach(s -> ret.add(s.toInfo()));
		return ret;
	}

	@Override
	public void Delete(Serializable id) throws Exception {
		int n = Integer.valueOf(id.toString());
		Set<UsuariSoci> usocis = FactoriaControladors.getInstance().getCtrlUsuariSoci().getAll();
		for (UsuariSoci u : usocis){
			if (u.getSoci().getNumero() == n){
				Usuari nou = new Usuari();
				nou.setCorreu(u.getCorreu());
				nou.setNom(u.getNom());
				nou.setCognoms(u.getCognoms());
				nou.setDni(u.getDni());
				nou.setPass(u.getPass());
				nou.setRang(u.getRang());
				FactoriaControladors.getInstance().getCtrlUsuari().Delete(u.getCorreu());
				FactoriaControladors.getInstance().getCtrlUsuari().Insert(nou);
			}
		}
		
		FactoriaControladors.getInstance().getCtrlSoci().Delete(Integer.valueOf(n));
	}

	@Override
	public Gestor getIndividualUpdater(Serializable id) throws Exception {
		return new GestorSociUpdate(Integer.valueOf(id.toString()));
	}

	@Override
	public Gestor getIndividualInserter() throws Exception {
		return new GestorSociInsert();
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getSoci();
	}


	
}
