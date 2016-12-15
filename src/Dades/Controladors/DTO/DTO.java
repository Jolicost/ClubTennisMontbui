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
import Dades.Excepcions.ViolacioNoNull;
import Dades.Factories.HibernateUtil;
import Domini.Model.Pista;
import Domini.Model.Soci;

public abstract class DTO {

	public void executar() throws BDExcepcio{
		try{
			SessionFactory s = HibernateUtil.getInstance().getSessionFactory();
			Session se = s.openSession();
	    	Transaction tx;
	    	tx = se.beginTransaction();
	    	performJob(se);
	    	tx.commit();
	    	se.close();
		}
    	catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
	}
	
	
	protected abstract void performJob(Session s) throws HibernateException;
	
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
