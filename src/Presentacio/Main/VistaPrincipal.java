package Presentacio.Main;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Errors.LlistaErrors;
import Presentacio.Components.Footer.Footer;
import Presentacio.Components.Nav.NavBar;
import Presentacio.TagBuilder.CustomTag;
import Presentacio.TagBuilder.NullTag;
import Presentacio.TagBuilder.TagFactory;

public class VistaPrincipal extends MultipleWebComponent {
	
	protected WebComponent content;
	public VistaPrincipal(WebComponent content){
		super();
		this.content = content;
	}

	@Override
	protected void createComponents() {
		super.AddComponent(new Wrapper());
		super.AddComponent(new Footer());
	}
	
	private class Wrapper extends MultipleWebComponent{

		@Override
		protected void createComponents() throws Exception {
			CustomTag t = new CustomTag();
			t.setTagName("div");
			t.setId("wrapper");
			this.setMainTag(t);
			
			super.AddComponent(new NavBar());
			super.AddComponent(new LlistaErrors(super.io.getErrors(),super.io.getSuccess()));
			
			CustomTag f = new CustomTag();
			f.setTagName("div");
			f.appendClass("container-fluid");
			content.addFirstTag(f);
			super.AddComponent(content);
			
		}
		
	}
}
