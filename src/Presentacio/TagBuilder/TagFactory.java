package Presentacio.TagBuilder;

import Presentacio.TagBuilder.Table.TableBodyTag;
import Presentacio.TagBuilder.Table.TableElementTag;
import Presentacio.TagBuilder.Table.TableHeaderElementTag;
import Presentacio.TagBuilder.Table.TableHeaderTag;
import Presentacio.TagBuilder.Table.TableRowTag;
import Presentacio.TagBuilder.Table.TableTag;

public class TagFactory {
	private static TagFactory instance = new TagFactory();
	public static TagFactory getInstance(){return instance;}
	
	private DefaultTag d = new DefaultTag();
	private ContainerTag t = new ContainerTag();
	
	private TableTag tt = new TableTag();
	private TableHeaderTag th = new TableHeaderTag();
	private TableRowTag tr = new TableRowTag();
	private TableElementTag te = new TableElementTag();
	private TableHeaderElementTag the = new TableHeaderElementTag();
	private TableBodyTag tb = new TableBodyTag();
	
	private NullTag nt = new NullTag();
	
	public ComponentTag getDefaultTag(){ return d;}
	public ComponentTag getContainerTag(){return t;}
	public TableTag getTableTag() {
		return tt;
	}
	public TableHeaderTag getTableHeaderTag() {
		return th;
	}
	public TableRowTag getTableRowTag() {
		return tr;
	}
	public TableElementTag getTableElementTag() {
		return te;
	}
	public TableHeaderElementTag getTableHeaderElementTag() {
		return the;
	}
	public TableBodyTag getTableBodyTag() {
		return tb;
	}
	public NullTag getNullTag(){
		return nt;
	}
}
