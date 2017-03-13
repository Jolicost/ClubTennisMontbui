package Presentacio.Components.Nav;

import java.io.IOException;

import javax.servlet.ServletException;
import Presentacio.TagBuilder.NavBarMenuItem;

public class MenuItem extends NavBarItem {
	private String name;
	private String link;
	private String glyph;
	
	public MenuItem(String name,String link){
		super();
		this.addTag(new NavBarMenuItem());
		this.name = name;
		this.link = link;
	}
	
	public MenuItem(String name,String link,String glyph){
		super();
		this.name = name;
		this.link = link;
		this.glyph = glyph;
	}
	@Override
	protected void writeContent()
			throws IOException, ServletException {
		
		String g = "";
		if (getGlyph()!= null) g = buildGylph();
		
		super.Append("<a href=\"" + link + "\">" + g + name +"</a>");
		
	}
	
	public String getGlyph(){return glyph;}
	
	private String buildGylph(){
		return "<span class=\"glyphicon glyphicon-" + getGlyph() + "\"></span> ";
	}
}
