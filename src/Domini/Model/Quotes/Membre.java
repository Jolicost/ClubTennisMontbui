package Domini.Model.Quotes;

import java.util.Set;

import Domini.Model.Reserves.ReservaSoci;

public class Membre extends Familiar {

	public Membre() {

	}

	private Titular titular;

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	
	public Set<ReservaSoci> ObtenirReserves(){
		return titular.ObtenirReserves();
	}

	@Override
	protected Set<Familiar> obtenirFamiliars() {
		return titular.obtenirFamiliars();
	}

	@Override
	public String toString() {
		return "Membre: " + titular.getPropietari().getNumero();
	}



}
