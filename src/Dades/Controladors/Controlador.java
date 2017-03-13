package Dades.Controladors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.PropertyValueException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import Dades.Excepcions.BDExcepcio;
import Dades.Excepcions.JaExisteix;
import Dades.Excepcions.NoExisteix;
import Dades.Excepcions.ViolacioNoNull;
import Dades.Factories.HibernateUtil;

public class Controlador  {

	@SuppressWarnings("rawtypes")
	public Set<Object> getAll(Class c) throws BDExcepcio{
		try{
			Set<Object> ret = new HashSet<>();
			SessionFactory s =  HibernateUtil.getInstance().getSessionFactory();
			Session se = s.openSession();
	    	Transaction tx;
	    	tx = se.beginTransaction();
	    	ret.addAll(se.createCriteria(c).list());
	    	tx.commit();
	    	se.close();
	    	return ret;
		}
		catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Object get(Class c,Serializable ser) throws BDExcepcio{
		try{
			Object ret;
			SessionFactory s = HibernateUtil.getInstance().getSessionFactory();
			Session se = s.openSession();
	    	Transaction tx;
	    	tx = se.beginTransaction();
	    	ret = se.get(c,ser);
	    	tx.commit();
	    	se.close();
	    	if (ret == null) throw new NoExisteix();
	    	return ret;
		}
    	catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
	}
	
	public void Insert(Object o)  throws BDExcepcio{
		try{
			SessionFactory s =  HibernateUtil.getInstance().getSessionFactory();
			Session se = s.openSession();
	    	Transaction tx;
	    	tx = se.beginTransaction();
	    	se.save(o);
	    	tx.commit();
	    	se.close();
		}
		catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
	}
	
	public void Update(Object o)  throws BDExcepcio{
		try{
			SessionFactory s =  HibernateUtil.getInstance().getSessionFactory();
			Session se = s.openSession();
	    	Transaction tx;
	    	tx = se.beginTransaction();
	    	se.update(o);
	    	tx.commit();
	    	se.close();
		}
		catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public boolean Exists(Class c,Serializable ser) throws BDExcepcio{
		try{
			Transaction tx;
			SessionFactory s =  HibernateUtil.getInstance().getSessionFactory();
			Session se = s.openSession();
			tx = se.beginTransaction();
		    Object t = se.get(c,ser);
		    tx.commit();
			se.close();
			return t != null;
		}
		catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
	}
	
	public void Delete(Object o) throws BDExcepcio{
		try{
		SessionFactory s =  HibernateUtil.getInstance().getSessionFactory();
		Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	
    	se.delete(o);
    	
    	tx.commit();
    	se.close();
		}
		catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void Delete(Class c,Serializable ser) throws BDExcepcio{
		try{
		SessionFactory s =  HibernateUtil.getInstance().getSessionFactory();
		Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction(); 	
    	Object o = se.get(c, ser);
    	se.delete(o);
    	tx.commit();
    	se.close();
		}
		catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
	}
	
	public void DeleteAll(String tableName)  throws BDExcepcio{
		try{
			String hql = String.format("delete from %s",tableName);
			SessionFactory s =  HibernateUtil.getInstance().getSessionFactory();
			Session se = s.openSession();
			Query query = se.createQuery(hql);
			query.executeUpdate();
			s.close();
		}
		catch(HibernateException h){
			throw TransformarExcepcio(h);
		}
		 
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
