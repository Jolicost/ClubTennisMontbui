package Presentacio.Main;

import Presentacio.Components.WebComponent;
import Presentacio.Components.Errors.LlistaErrors;
import Presentacio.Components.Footer.Footer;
import Presentacio.Components.Nav.NavBar;
import Presentacio.TagBuilder.NullTag;

public class VistaPrincipalErrors extends VistaPrincipal {

	public VistaPrincipalErrors(WebComponent content) {
		super(content);
	}
	
	@Override
	protected void createComponents() {
		this.addTag(new NullTag());
		super.AddComponent(new NavBar());
		super.AddComponent(new LlistaErrors());
		super.AddComponent(content);
		super.AddComponent(new Footer());
	}

}
