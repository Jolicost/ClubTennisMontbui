package Presentacio.Components;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;

import Presentacio.Controladors.IWebIO;
import Presentacio.Controladors.IWebWritter;
import Presentacio.Controladors.WebIO;
import Presentacio.Controladors.WebWritter;
import Presentacio.TagBuilder.ComponentTag;
import Presentacio.TagBuilder.TagFactory;
import Presentacio.Vistes.Rols.Rol;

public abstract class WebComponent {

	protected List<ComponentTag> tags;
	protected IWebWritter ww;
	protected IWebIO io;


	public WebComponent(){
		tags = new LinkedList<>();
	}
	
	public void addTag(ComponentTag tag){tags.add(tag);}
	public void addFirstTag(ComponentTag tag){tags.add(0,tag);}
	public ComponentTag getFirstTag(){
		if (tags.size() > 0) return tags.get(0);
		else return null;
	}
	public void MergeTag(ComponentTag t){
		for (ComponentTag ta : tags) ta.Merge(t);
	}
	
	public void setMainTag(ComponentTag t){
		if (tags.size() > 0) tags.set(0, t);
		else addTag(t);
	}
	
	protected void Append(String s) throws IOException{
		ww.Append(s);
	}
	
	protected void IncludeFile(String file) throws IOException, ServletException{
		ww.IncludeFile(file);
	}
	
	
	public void Include() throws IOException, ServletException{
		IncludeMetadata();
		writeStart();
		writeContent();
		writeEnd();
	}
	
	protected Rol getRol(){return io.getRol();}
	public boolean HasChilds(){return false;}
	public abstract Collection<WebComponent> createChilds() throws Exception;
	
	public void setWritter(IWebWritter ww){this.ww = ww;}
	public void setDomain(IWebIO io){this.io = io;}
	
	protected void writeStart() throws IOException, ServletException{
		if (tags.size() > 0){
			for (ComponentTag t:tags){
				ww.WriteTagStart(t);
			}
		}
		else{
			if (HasDefaultTag()) ww.WriteTagStart(getDefaultTag());	
		}
		
	}
	
	public void InitContent(){}
	
	protected void writeEnd() throws IOException, ServletException{
		if (tags.size() > 0){
			for (ComponentTag t:tags){
				ww.WriteTagEnd(t);
			}
		}
		else{
			if (HasDefaultTag()) ww.WriteTagEnd(getDefaultTag());	
		}
	}
	protected abstract void writeContent() throws IOException, ServletException;
	protected void IncludeMetadata() throws IOException,ServletException{}
	
	protected boolean HasDefaultTag(){return true;}
	protected ComponentTag getDefaultTag(){
		return TagFactory.getInstance().getDefaultTag();
	}


}
