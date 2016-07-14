package Domini.CasosUs.Gestors.Controlador;

import java.util.Stack;

import Communicacio.Excepcions.CapGestor;
import Domini.CasosUs.Descriptors.CasUs;

public class CuaCasosUs {

	private Stack<CasUs> gestors;
	
	public CuaCasosUs(){
		gestors = new Stack<>();
	}
	public void Root(CasUs g){
		gestors.empty();
		gestors.push(g);
	}
	
	public void Empty(){
		gestors.empty();
	}
	
	public CasUs Top() throws CapGestor{
		if (gestors.isEmpty()) throw new CapGestor();
		else return gestors.peek();
	}
	public CasUs Pop() throws CapGestor{
		if (gestors.isEmpty()) throw new CapGestor();
		else return gestors.pop();
	}
	public void Push(CasUs g){
		gestors.push(g);
	}
}
