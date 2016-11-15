package Domini.CasosUs.Gestors.Franges;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoHorari;
import Communicacio.Dades.InfoLapse;
import Communicacio.Excepcions.GestorInvalid;
import Domini.CasosUs.Gestors.Gestor;
import Domini.Model.Pista;
import Domini.Model.Reserves.Franja;
import Factories.FactoriaControladors;

public class GestorFrangesTotal extends GestorFranges {

	@Override
	public Gestor getIndividualUpdater(Serializable id) throws Exception {
		int idFranja = Integer.valueOf(id.toString());
		Franja f = FactoriaControladors.getInstance().getCtrlFranja().get(idFranja);
		return f.getTipusFranja().getGestorFranjaUpdate(idFranja);
	}
	
	@Override
	public Set<Info> getAll() throws Exception {
		Set<Info> ret = new HashSet<>();
		Set<Pista> pi = FactoriaControladors.getInstance().getCtrlPista().getAll();
		for (Pista p:pi){
			InfoHorari ih = new InfoHorari();
			SortedSet<InfoLapse> franges = new TreeSet<>();
			for (Franja f:p.getFranges()){
				franges.add(f.toInfo());
			}
			ih.setDisponibilitats(franges);
			ih.setNomPista(p.getNom());
			ih.setIDPista(p.getIDPista());
			
			ret.add(ih);
		}
		
		return ret;
	}
	
	public Set<Info> getAllInterval(DateTime d1,DateTime d2) throws Exception{
		Interval i = new Interval(d1,d2);
		Set<Info> ret = new HashSet<>();
		Set<Pista> pi = FactoriaControladors.getInstance().getCtrlPista().getAll();
		for (Pista p:pi){
			InfoHorari ih = new InfoHorari();
			SortedSet<InfoLapse> franges = new TreeSet<>();
			for (Franja f:p.getFrangesCondicio(fa -> fa.Intersecciona(i))){
				franges.add(f.toInfo());
			}
			ih.setDisponibilitats(franges);
			ih.setNomPista(p.getNom());
			ih.setIDPista(p.getIDPista());
			
			ret.add(ih);
		}
		
		return ret;
	}

	@Override
	public Gestor getIndividualInserter() throws Exception {
		throw new GestorInvalid();
	}

	@Override
	public String getEntitat() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
