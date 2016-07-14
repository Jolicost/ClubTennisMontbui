package Presentacio.Components.Gestors.Taules;

import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.TagFactory;

public class TaulaGrupCos extends TaulaGrup{

	@Override
	protected ComponentTag getGrupTag() {
		return TagFactory.getInstance().getTableBodyTag();
	}

	@Override
	protected Fila getFila() {
		return new FilaElement();
	}

}
