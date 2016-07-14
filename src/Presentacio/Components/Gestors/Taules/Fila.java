package Presentacio.Components.Gestors.Taules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import Presentacio.Components.SingleWebComponent;
import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.TagFactory;

public abstract class Fila extends SingleWebComponent {

	private List<String> columns;
	public Fila(){
		columns = new ArrayList<>();
		super.setMainTag(TagFactory.getInstance().getTableRowTag());
	}
	@Override
	protected void writeContent() throws IOException, ServletException {
		for (String s: columns){
			super.ww.WriteTagStart(getElementTag());
			if (s != null) super.Append(s);
			super.ww.WriteTagEnd(getElementTag());
		}
	}
	
	public void setColumns(List<String> columns){
		this.columns = columns;
	}
	
	protected abstract ComponentTag getElementTag();
	

}
