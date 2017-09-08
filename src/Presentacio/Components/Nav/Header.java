package Presentacio.Components.Nav;

public abstract class Header extends NavBarItem{

	public Header(){
		super();
		this.setMainTag(new Presentacio.TagBuilder.NavBarItem("header"));
	}

}
