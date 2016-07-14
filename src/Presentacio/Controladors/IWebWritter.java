package Presentacio.Controladors;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.TagBuilder.ComponentTag;

public interface IWebWritter {

	public void IncludeFile(String file) throws ServletException, IOException;
	
	public void Append(String s) throws IOException;
	
	public void WriteTagStart(ComponentTag t) throws IOException, ServletException;
	
	public void WriteTagEnd(ComponentTag t) throws IOException, ServletException;
}
