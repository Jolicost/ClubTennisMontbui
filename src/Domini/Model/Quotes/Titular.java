package Domini.Model.Quotes;

import java.util.HashSet;
import java.util.Set;

import Domini.Excepcions.SociNoTitular;
import Domini.Model.Soci;

public class Titular extends Familiar {

	public Titular() {
		super();
		familiars = new HashSet<>();
	}

	private Set<Membre> familiars;

	public Set<Membre> getFamiliars() {
		return familiars;
	}

	public void setFamiliars(Set<Membre> familiars) {
		this.familiars = familiars;
	}
	public Titular getTitular() throws SociNoTitular{
		return this;
	}

	@Override
	protected Set<Familiar> obtenirFamiliars() {
		Set<Familiar> ret = new HashSet<>();
		ret.addAll(familiars);
		ret.add(this);
		return ret;
	}
	
	public boolean EsTitular(){
		return true;
	}
	
	public Set<Soci> getMembres() throws SociNoTitular{
		Set<Soci> ret = new HashSet<>();
		for (Membre m: this.familiars){
			ret.add(m.getPropietari());
		}
		return ret;
	}
	
	public void AfegirMembre(Membre m) throws SociNoTitular{
		familiars.add(m);
		m.setTitular(this);
	}
	
	@Override
	public String toString() {
		return "Titular";
	}

}
