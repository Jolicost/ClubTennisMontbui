package Domini.CasosUs.Gestors.Usuaris;

import java.util.Set;

import Communicacio.Dades.InfoUsuari;
import Communicacio.Excepcions.InsuficientPermis;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Accions.Accio;
import Domini.Excepcions.SociJaAssignat;
import Domini.Model.Usuari;
import Domini.Model.UsuariSoci;
import Domini.Model.Rang.FactoriaRangs;
import Domini.Model.Rang.Rang;
import Factories.FactoriaControladors;

public class GestorUsuariNormal extends GestorUsuari {

	public GestorUsuariNormal(String correu,Accio accio) {
		super(correu,accio);
	}
	
	public GestorUsuariNormal(Accio accio){
		super(accio);
	}

	protected void editar(InfoUsuari u,Usuari us) throws Exception {
		if (u.getEmail() != us.getCorreu()) throw new InsuficientPermis();
		if (u.getEmail() != null) us.setCorreu(u.getEmail());
		if (u.getNom() != null) us.setNom(u.getNom());
		if (u.getDni() != null) us.setDni(u.getDni());
		

		
	}

	@Override
	protected void PopulateInsert(InfoUsuari i,Usuari u) {
		u.setRangOriginal(FactoriaRangs.getInstance().getNormal());
	}

	protected void ComprovarUnicitatUsuari(String dni) throws SociJaAssignat,BDExcepcio{
		Set<UsuariSoci> socis = FactoriaControladors.getInstance().getCtrlUsuariSoci().getAll();
		for (UsuariSoci us:socis) {
			if (Utils.DniCheck.Check(dni, us.getS().getDni())) {
				throw new SociJaAssignat();
			}
		}
	}
	






}
