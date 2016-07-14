package Domini.CasosUs.Gestors.Accions;

public class FactoriaAccions {
	private static FactoriaAccions instance = new FactoriaAccions();
	public static FactoriaAccions getInstance(){return instance;}
	
	private Accio insert = new AccioInsert();
	private Accio update = new AccioUpdate();

	public Accio getInsert(){return insert;}
	public Accio getUpdate(){return update;}
}
