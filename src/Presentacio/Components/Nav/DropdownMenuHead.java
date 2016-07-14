package Presentacio.Components.Nav;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.Components.SingleWebComponent;
import Presentacio.TagBuilder.LinkTag;

public class DropdownMenuHead extends SingleWebComponent {

	private String nom;
	public DropdownMenuHead(String nom){
		this.nom = nom;
		
		LinkTag t = new LinkTag("#");
		t.appendClass("dropdown-toggle");
		t.appendAttribute("data-toggle", "dropdown");
		this.setMainTag(t);
		
	}
	@Override
	protected void writeContent() throws IOException, ServletException {
		super.Append(nom);
		super.Append("<span class=\"caret\"></span>");
	}

}
