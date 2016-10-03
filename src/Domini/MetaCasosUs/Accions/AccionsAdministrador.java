package Domini.MetaCasosUs.Accions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.InfoAccioGrup;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.Model.Rang.Admin;
import Domini.Model.Rang.FactoriaRangs;
import Domini.Model.Rang.Rang;

public class AccionsAdministrador extends GrupAccions{


	public AccionsAdministrador(){
		super();
	}
	
	protected void crearMenu(){
		Rang admin = FactoriaRangs.getInstance().getAdmin();
		Rang monitor = FactoriaRangs.getInstance().getMonitor();
		menu.add(new AccioGestorEntitat("Usuaris",admin.getPermis(),FactoriaEntitats.getInstance().getUsuari()));
		menu.add(new AccioGestorEntitat("Socis",admin.getPermis(),FactoriaEntitats.getInstance().getSoci()));
		menu.add(new AccioGestorEntitat("Pistes",monitor.getPermis(),FactoriaEntitats.getInstance().getPista()));
		menu.add(new AccioGestorEntitat("Calendaris",admin.getPermis(),FactoriaEntitats.getInstance().getCalendari()));
		menu.add(new AccioGestorEntitat("Franges",monitor.getPermis(),FactoriaEntitats.getInstance().getFranges()));
	}

	@Override
	public int getMinRang() {
		return  FactoriaRangs.getInstance().getMonitor().getPermis();
	}

	@Override
	protected String getNomGrup() {
		return "Administrar";
	}
	
	
}
