package Presentacio.Components.Gestors.Taules;

import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.TagFactory;

public class FilaElement extends Fila {

	@Override
	protected ComponentTag getElementTag() {
		return TagFactory.getInstance().getTableElementTag();
	}

}
