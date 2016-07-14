package Presentacio.Components;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MultipleWebComponent extends WebComponent {
	private List<WebComponent> components;

	public MultipleWebComponent(){
		super();
		components = new LinkedList<>();
	}
	@Override
	protected void writeContent() throws IOException, ServletException {
		for (WebComponent w: components) w.Include();
	}
	
	public boolean HasChilds(){return true;}
	
	public Collection<WebComponent> createChilds() throws Exception{
		createComponents();
		return components;
	}
	
	protected WebComponent getFirst(){return components.get(0);}
	protected void IncludeMetadata() throws IOException,ServletException{}

	protected void AddComponent(WebComponent w){
		components.add(w);
	}
	protected abstract void createComponents() throws Exception;
}
