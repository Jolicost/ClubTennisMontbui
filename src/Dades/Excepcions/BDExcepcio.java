package Dades.Excepcions;

public class BDExcepcio extends Exception{

	/**
	 * 
	 */
	public BDExcepcio(){super();}
	public BDExcepcio(String msg){super(msg);}
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.getMessage();
	}

}
