package Presentacio.Components.Nav;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Header extends NavBarItem{

	public Header(){
		super();
		this.setMainTag(new Presentacio.TagBuilder.NavBarItem("header"));
	}

}
