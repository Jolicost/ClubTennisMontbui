package Presentacio.Components.Gestors;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.TagBuilder.CenteredDesktopColumnTag;

public abstract class VistaIndividual extends MultipleWebComponent {

	@Override
	public void InitContent() {
		super.addTag(new CenteredDesktopColumnTag());
	}


}
