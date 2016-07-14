package Presentacio.Components.Formularis.Inputs;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.Components.SingleWebComponent;
import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.CustomTag;

public class LabelZone extends SingleWebComponent{

	private String label;
	private String forid;
	
	private ComponentTag t;


	public LabelZone() {
		t = new CustomTag();
		t.setTagName("label");
		super.addTag(t);
	}

	@Override
	protected void writeContent() throws IOException, ServletException {
		super.Append(label);
	}

	@Override
	public void InitContent() {
		super.InitContent();
		t.setAttribute("for", forid);
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setForid(String forid) {
		this.forid = forid;
	}
}
