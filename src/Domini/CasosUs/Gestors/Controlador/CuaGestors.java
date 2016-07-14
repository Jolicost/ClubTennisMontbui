package Domini.CasosUs.Gestors.Controlador;

import java.io.Serializable;
import java.util.Set;
import java.util.Stack;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Communicacio.Excepcions.CapGestor;
import Domini.CasosUs.Gestors.Gestor;
import Domini.Excepcions.CapCasUs;

public class CuaGestors {

	private Stack<Gestor> gestors;
	
	public CuaGestors(){
		gestors = new Stack<>();
	}
	public void Root(Gestor g){
		gestors.empty();
		gestors.push(g);
	}
	public void Empty(){
		gestors.empty();
	}
	public Gestor Top() throws CapCasUs{
		if (gestors.isEmpty()) throw new CapCasUs();
		else return gestors.peek();
	}
	public Gestor Pop() throws CapCasUs{
		if (gestors.isEmpty()) throw new CapCasUs();
		else return gestors.pop();
	}
	public void Push(Gestor g){
		gestors.push(g);
	}
	

	
}
