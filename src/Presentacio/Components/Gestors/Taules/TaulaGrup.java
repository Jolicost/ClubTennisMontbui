package Presentacio.Components.Gestors.Taules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.TagBuilder.ComponentTag;

public abstract class TaulaGrup extends MultipleWebComponent {

	private Set<List<String>> content;
	
	public TaulaGrup(){
		content = new HashSet<>();
	}
	public void setContent(Set<List<String>> content){this.content = content;}
	@Override
	protected void createComponents() {
		super.setMainTag(getGrupTag());
		for (List<String> l : content){
			Fila f = getFila();
			f.setColumns(l);
			super.AddComponent(f);
		}
		
	}
	
	public void addFila(List<String> fila){
		content.add(fila);
	}
	
	
	protected abstract ComponentTag getGrupTag();
	protected abstract Fila getFila();

}
