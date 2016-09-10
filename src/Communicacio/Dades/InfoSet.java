package Communicacio.Dades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class InfoSet extends Info {

	public InfoSet() {
		super();
	}

	private String[] set;

	public String[] getSet() {
		return set;
	}

	public void setSet(String[] set) {
		this.set = set;
	}

	@Override
	public Info toInfo(String json) {
		Gson gson = new Gson();
		set = gson.fromJson(json, String[].class);
		return this;
	}
	
	public Set<Serializable> getIds(){
		Set<Serializable> ret = new HashSet<>();
		for (String s: set) ret.add(s);
		return ret;
	}


}
