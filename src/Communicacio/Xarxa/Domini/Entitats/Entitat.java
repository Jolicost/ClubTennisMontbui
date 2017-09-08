package Communicacio.Xarxa.Domini.Entitats;

import javax.servlet.ServletRequest;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.EntitatInvalida;
import Communicacio.Excepcions.NoTeGestor;
import Communicacio.Xarxa.Domini.Entitats.Constructors.ConstructorEntitat;
import Communicacio.Xarxa.Domini.Entitats.Constructors.FactoriaConstructors;
import Domini.CasosUs.Gestors.GestorColectiu;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;

public abstract class Entitat {

	
	
	
	public abstract String getEntitat();
	
	public abstract VistaGestorEntitat getGestorEntitat();
	public abstract GestorColectiu getGestor() throws NoTeGestor ;
	public abstract VistaSelectEntitat getSelectorEntitat();
	public abstract Info getInfo();
	
	public abstract VistaGestorIndividual getGestorIndividual();
	public abstract VistaInsertIndividual getInsertIndividual();
	
	protected ConstructorEntitat getConstructor(){
		return FactoriaConstructors.getInstance().getFormulari();
	}
	public Info crearInfo(ServletRequest req) throws IllegalArgumentException, IllegalAccessException, EntitatInvalida{
		Info i = getInfo();
		return this.getConstructor().construir(i, req);
	}
	
	
}
