package Domini.CasosUs.Controladors.PujarSocis;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import Communicacio.Dades.PujarSocis.InfoPlantillaSoci;
import Communicacio.Dades.PujarSocis.InfoPujarSoci;
import Domini.InterficieBD.CtrlQuota;
import Domini.InterficieBD.CtrlSoci;
import Domini.Model.Soci;
import Factories.FactoriaControladors;

public class TrPujarSocis {

	public TrPujarSocis(Set<InfoPlantillaSoci> socis) {
		super();
		this.socis = socis;
	}

	private Set<InfoPlantillaSoci> socis;
	
	
	public void Executar() throws Exception{
		Set<InfoPujarSoci> s = new HashSet<>();
		for (InfoPlantillaSoci ip : socis) s.add(ip.toInfoPujarSoci());
		
		CtrlSoci ctrl = FactoriaControladors.getInstance().getCtrlSoci();
		
		TrCrearSocis tr = new TrCrearSocis(s,ctrl.getAll());
		tr.Executar();
		
		CtrlQuota ctrlq = FactoriaControladors.getInstance().getCtrlQuota();
		
		SortedSet<Soci> prioritaris = new TreeSet<>(new ComparadorSocis());
		prioritaris.addAll(tr.getResultat());
		
		for (Soci soc: prioritaris){
			ctrl.Insert(soc);
			ctrlq.Insert(soc.getQ());
		}
	}
	
	
	private class ComparadorSocis implements Comparator<Soci>{

		@Override
		public int compare(Soci o1, Soci o2) {
			if (o1.EsTitular() && !o2.EsTitular()){
				return -1;
			}
			else return 1;
		}
		
	}
}
