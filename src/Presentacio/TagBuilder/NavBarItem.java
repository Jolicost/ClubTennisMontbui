package Presentacio.TagBuilder;

public class NavBarItem extends ComponentTag{

	public NavBarItem(String itemname){
		super();
		super.setAttribute("class","navbar-" + itemname);
	}
}
