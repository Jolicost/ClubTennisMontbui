package Dades.Controladors.DTO;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import Domini.Model.Soci;

public class DTOConjuntSocis extends DTO {

	private Set<Integer> ids;
	private Set<Soci> result;
	public DTOConjuntSocis(Set<Integer> ids){
		this.ids = ids;
		result = new HashSet<>();
	}
	@Override
	protected void performJob(Session s) throws HibernateException {
		for (Integer i: ids){
			result.add((Soci)s.get(Soci.class,i));
		}
	}
	
	public Set<Soci> getResult(){
		return result;
	}
	
	
}
