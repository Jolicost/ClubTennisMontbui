package Domini.Model.Quotes;

import java.util.Set;

import Domini.Excepcions.SociNoTitular;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;
import Factories.FactoriaNormes;

public abstract class Quota {
	
	
	
	private Soci propietari;
	private int id;
	public Quota(){
		
	}
	

	public Soci getPropietari() {
		return propietari;
	}
	public void setPropietari(Soci propietari) {
		this.propietari = propietari;
		id = propietari.getNumero();
	}
	
	public abstract String toString();
	
	public Set<ReservaSoci> ObtenirReserves(){
		return propietari.getReserves();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public int getInvitacionsMes(){
		return 1;
	}
	
	public abstract int getReservesSetmana();
	
	public boolean EsTitular(){
		return false;
	}
	
	public Titular getTitular() throws SociNoTitular{
		throw new SociNoTitular();
	}

	public Set<Soci> getMembres() throws SociNoTitular{
		throw new SociNoTitular();
	}
	
	public void AfegirMembre(Membre m) throws SociNoTitular{
		throw new SociNoTitular();
	}


	@Override
	public boolean equals(Object obj) {
		Quota q = (Quota)obj;
		return q.getPropietari().equals(this.getPropietari());
	}
	


}
