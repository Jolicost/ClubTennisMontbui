package Communicacio.Descriptors;

import java.util.HashMap;
import java.util.Map;

import Communicacio.Excepcions.DescriptorInvalid;

public class FactoriaDescriptors {
	private static FactoriaDescriptors instance = new FactoriaDescriptors();
	public static FactoriaDescriptors getInstance(){return instance;}
	
	private Map<String,DescriptorGestor> descriptors;
	
	private DescriptorCRUD crud;
	private DescriptorSelector sel;
	private DescriptorInsert ins;
	private DescriptorUpdate up;
	
	public FactoriaDescriptors(){
		descriptors = new HashMap<>();
		
		crud = new DescriptorCRUD();
		sel = new DescriptorSelector();
		ins = new DescriptorInsert();
		up = new DescriptorUpdate();
		
		Populate();
	}
	private void Populate(){
		descriptors.put(crud.getName(), crud);
		descriptors.put(sel.getName(), sel);
		descriptors.put(ins.getName(), ins);
		descriptors.put(up.getName(), up);
	}
	
	public String getCRUD(){return crud.getName();}
	public String getInsert(){return ins.getName();}
	public String getUpdate(){return up.getName();}
	public String getSelect(){return sel.getName();}

	public DescriptorGestor get(String name) throws DescriptorInvalid{
		if (descriptors.containsKey(name)) return descriptors.get(name);
		else throw new DescriptorInvalid();
	}
}
