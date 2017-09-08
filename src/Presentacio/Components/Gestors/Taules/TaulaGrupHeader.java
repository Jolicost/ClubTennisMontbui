package Presentacio.Components.Gestors.Taules;

import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.TagFactory;

public class TaulaGrupHeader extends TaulaGrup {

	@Override
	protected ComponentTag getGrupTag() {
		return TagFactory.getInstance().getTableHeaderTag();
	}

	@Override
	protected Fila getFila() {
		return new FilaHeader();
	}


}
