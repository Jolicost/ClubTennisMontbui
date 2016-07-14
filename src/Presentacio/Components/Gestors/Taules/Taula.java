package Presentacio.Components.Gestors.Taules;

import java.util.List;
import java.util.Set;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.TagBuilder.Table.TableTag;

public class Taula extends MultipleWebComponent {

	private List<String> header;
	private Set<List<String>> values;
	public Taula(List<String> header,Set<List<String>> values){
		this.header = header;
		this.values = values;
	}
	@Override
	protected void createComponents() {
		TableTag t = new TableTag();
		t.setCls("table");
		t.setAttribute("id", "example");
		super.setMainTag(t);
		
		TaulaGrupHeader h = new TaulaGrupHeader();
		h.addFila(header);
		super.AddComponent(h);
		
		TaulaGrupCos b = new TaulaGrupCos();
		b.setContent(values);
		super.AddComponent(b);
	}

}
