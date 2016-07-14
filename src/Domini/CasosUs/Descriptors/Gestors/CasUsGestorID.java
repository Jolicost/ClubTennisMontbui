package Domini.CasosUs.Descriptors.Gestors;

import java.io.Serializable;

public abstract class CasUsGestorID extends CasUsGestor {

	public CasUsGestorID(String entitat, Serializable id) {
		super(entitat);
		this.id = id;
	}
	
	public CasUsGestorID(Serializable id){
		this.id = id;
	}
	public CasUsGestorID(){}

	protected Serializable id;

	public Serializable getId() {
		return id;
	}

	public void setId(Serializable id) {
		this.id = id;
	}
	
}
