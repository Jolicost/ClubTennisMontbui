package Presentacio.Components;

import java.util.HashSet;
import java.util.Set;

public abstract class SingleWebComponent extends WebComponent {

	public SingleWebComponent() {
	}
	
	public Set<WebComponent> createChilds(){return new HashSet<>();}

}
