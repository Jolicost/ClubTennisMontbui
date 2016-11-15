package Domini.MetaCasosUs.Accions;

import java.util.ArrayList;
import java.util.List;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.InfoAccioGrup;

public abstract class GrupAccions {

	protected List<Accio> menu;
	
	public GrupAccions(){
		menu = new ArrayList<>();
		crearMenu();
	}
	
	protected abstract void crearMenu();
	public abstract int getMinRang();
	protected abstract String getNomGrup();

	public List<Accio> getMenu() {
		return menu;
	}
	
	public InfoAccioGrup crearInfoGrup(){
		InfoAccioGrup ret = new InfoAccioGrup();
		ret.setTitol(getNomGrup());
		List<InfoAccio> accions = new ArrayList<>();
		for (Accio a: menu) accions.add(a.toInfo());
		ret.setGrup(accions);
		return ret;
	}

	

}
