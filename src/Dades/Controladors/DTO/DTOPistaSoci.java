package Dades.Controladors.DTO;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import Dades.Excepcions.BDExcepcio;
import Dades.Excepcions.JaExisteix;
import Dades.Excepcions.NoExisteix;
import Dades.Excepcions.ViolacioNoNull;
import Dades.Factories.HibernateUtil;
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
	
	public void executar() throws BDExcepcio{
		try{
			SessionFactory s = HibernateUtil.getInstance().getSessionFactory();
			Session se = s.openSession();
	    	Transaction tx;
	    	tx = se.beginTransaction();
	    	pista = (Pista) se.get(Pista.class,this.IDPista);
	    	soci = (Soci) se.get(Soci.class, this.nsoci);
	    	tx.commit();
	    	se.close();
		}
    	catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
	}

	public Pista getPista() {
		return pista;
	}

	public Soci getSoci() {
		return soci;
	}
	
	private BDExcepcio TransformarExcepcio(HibernateException e){
		try{
			tirar(e);
		}
		catch(NonUniqueObjectException | ConstraintViolationException i){
			return new JaExisteix();
		}
		catch(PropertyValueException h){
			return new ViolacioNoNull();
		}
		catch(HibernateException h){
			return new BDExcepcio(h.getMessage());
		}
		return null;
	}
	
	private void tirar(HibernateException e) throws HibernateException{
		throw e;
	}

}
