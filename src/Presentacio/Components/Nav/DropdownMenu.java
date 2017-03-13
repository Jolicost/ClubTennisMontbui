package Presentacio.Components.Nav;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.Lists.ListElementTag;

public class DropdownMenu extends MultipleWebComponent {

	private DropdownMenuList l;
	private String name;
	
	public DropdownMenu(String name) {
		l = new DropdownMenuList();
		this.name = name;
	}
	
	public void AddItem(MenuItem w){
		l.AddItem(w);
	}


	@Override
	protected void createComponents() {
		ComponentTag t = new ListElementTag();
		t.setCls("dropdown");
		this.setMainTag(t);
		
		super.AddComponent(new DropdownMenuHead(name));
		super.AddComponent(l);
		
	}

}
