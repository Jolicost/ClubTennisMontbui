package Presentacio.TagBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ComponentTag {


	private Map<String,String> attributes;
	
	private String tag;
	
	private boolean skipend;

	public ComponentTag(){
		attributes = new HashMap<>();
		skipend = false;
	}
	
	public void Merge(ComponentTag t){
		for (String s : t.attributes.keySet()){
			this.appendAttribute(s, t.getAttribute(s));
		}
	}
	
	public void SkipEnd(boolean skip){
		skipend = skip;
	}
	
	
	public void writeStart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.getWriter().append("<" + buildComponentTag() + ">\n");
	}
	
	public String writeStart(){
		return "<" + buildComponentTag() + ">\n";
	}
	
	public String writeEnd(){
		if (skipend) return "";
		else return "</" + getComponentTag() + ">\n";
	}
	
	public void writeEnd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		if (!skipend)
		response.getWriter().append(writeEnd());
	}

	public void setTagName(String tag){this.tag = tag;}
	
	
	protected String buildComponentTag(){
		String ret = getComponentTag();
		if (ret == null) ret = "div";
		for (String s: attributes.keySet()){
			ret += " " + s + "=" + "\"" + attributes.get(s) + "\"";
		}
		return ret;
	}
	
	public void setComponentTag(String tag){this.tag = tag;}
	
	protected String getComponentTag(){
		if (tag == null) return "div";
		else return tag;
	};

	public String getId() {
		return attributes.get("id");
	}

	public void setId(String id) {
		attributes.put("id", id);
	}
	
	public void setAttribute(String name,String value){
		attributes.put(name, value);
	}
	public void appendClass(String value){
		appendAttribute("class",value);
	}
	public void appendAttribute(String name,String value){
		if (attributes.containsKey(name)){
			String actual = attributes.get(name);
			actual += " " + value;
			attributes.put(name, actual);
		}
		else attributes.put(name, value);
	}
	
	public String getAttribute(String name){
		return attributes.get(name);
	}

	public String getCls() {
		return attributes.get("class");
	}

	public void setCls(String cls) {
		attributes.put("class",cls);
	}
}
