package Presentacio.TagBuilder;

public class LinkTag extends ComponentTag {

	public LinkTag(String link){
		super();
		super.appendAttribute("href", link);
	}
	@Override
	protected String getComponentTag() {
		return "a";
	}

}
