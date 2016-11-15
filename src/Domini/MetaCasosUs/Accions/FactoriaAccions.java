package Domini.MetaCasosUs.Accions;

public class FactoriaAccions {

	private static FactoriaAccions instance = new FactoriaAccions();
	public static FactoriaAccions getIntance(){return instance;}
	
	private GrupAccions administrar = new AccionsAdministrador();
	private GrupAccions reservar = new AccionsReservar();
	private GrupAccions veureReserves = new AccionsVeureReserves();
	
	public GrupAccions getAdministrar(){
		return administrar;
	}
	public GrupAccions getReservar(){
		return reservar;
	}
	public GrupAccions getVeureReserves(){
		return veureReserves;
	}
	

	
}
