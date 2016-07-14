package Presentacio.Components.Gestors.Taules;

import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.TagFactory;

public class FilaHeader extends Fila {


	@Override
	protected ComponentTag getElementTag() {
		return TagFactory.getInstance().getTableHeaderElementTag();
	}

}
