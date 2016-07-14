package Presentacio.Components.Nav;

import java.util.ArrayList;
import java.util.List;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.TagBuilder.Lists.ListTag;

public class DropdownMenuList extends MultipleWebComponent {

	private List<MenuItem> elements;

	public DropdownMenuList(){
		this.elements = new ArrayList<>();
	}
	@Override
	protected void createComponents() {
		ListTag l = new ListTag();
		l.setCls("dropdown-menu");
		this.setMainTag(l);
		for (MenuItem m : elements) super.AddComponent(m);
	}
	
	public void AddItem(MenuItem m){
		elements.add(m);
	}
	
}
