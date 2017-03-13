package Dades.Controladors.DTO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import Domini.Model.Pista;
import Domini.Model.Soci;

public class DTOPistaSoci extends DTO{
	
	private int IDPista;
	private int nsoci;
	
	private Pista pista;
	private Soci soci;
	
	public DTOPistaSoci(int idPista,int nsoci){
		this.IDPista = idPista;
		this.nsoci = nsoci;
	}

	public Pista getPista() {
		return pista;
	}

	public Soci getSoci() {
		return soci;
	}

	@Override
	protected void performJob(Session s) throws HibernateException {
	  	pista = (Pista) s.get(Pista.class,this.IDPista);
    	soci = (Soci) s.get(Soci.class, this.nsoci);
	}


}
