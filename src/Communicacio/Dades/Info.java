package Communicacio.Dades;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Communicacio.Dades.Reserves.InfoReserva;
import Communicacio.Dades.Reserves.InfoReservaSoci;
import Communicacio.Dades.Reserves.InfoReservar;
import Communicacio.Excepcions.DadaIncorrecta;
import Communicacio.Excepcions.EntitatInvalida;
import Presentacio.Controladors.WebBuilder;
import Utils.gsonjodatime.Converters;

public abstract class Info {

	
	
	public String toJSon(){
		Gson s = Converters.registerAll(new GsonBuilder()).create();
		return s.toJson(this);
	}
	
	public Info toInfo(String json){
		Gson s = Converters.registerAll(new GsonBuilder()).create();
		return s.fromJson(json,this.getClass());
	}
	
	public String getAttribute(String name){
		
		try {
			Field f;
			f = this.getClass().getField(name);
			return f.get(this).toString();
		} catch (Exception e) {
			return null;
		}

	}
	
	public InfoUsuari toInfoUsuari() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoSoci toInfoSoci() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoPista toInfoPista() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoCalendari toInfoCalendari() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoObertura toInfoObertura() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoReservar toInfoReservar() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoOcupacio toInfoOcupacio() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoLapse toInfoLapse() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoObertures toInfoObertures() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoFranja toInfoFranja() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoReservaSoci toInfoReservaSoci() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoOcupacions toInfoOcupacions() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	
	public InfoReserva toInfoReserva() throws DadaIncorrecta{
		throw new DadaIncorrecta();
	}
	public List<String> getAttributeNames(){
		Field[] fields = this.getClass().getFields();
		List<String> ret = new ArrayList<>();
		for (int i = 0; i < fields.length ; i ++){
			ret.add(fields[i].getName());
		}
		return ret;	
	}
	
	public List<String> getAttributeValues(){
		Field[] fields = this.getClass().getFields();
		List<String> ret = new ArrayList<>();
		for (int i = 0; i < fields.length ; i++){
			try {
				ret.add(fields[i].get(this).toString());
			}
			catch (Exception e){
				ret.add(null);
			}
		}
		return ret;
	}
	
	public Info Populate(Map<String,String[]> params) throws IllegalArgumentException, IllegalAccessException, EntitatInvalida{
		
		Field[] fs = this.getClass().getFields();
		for (Field f: fs){
			String n = f.getName().toLowerCase();
			if (params.containsKey(n)){
				f.set(this, params.get(n)[0]);
			}
		}
		return this;
	}
	
	public void PopulateParameters(WebBuilder w){
		
	}
	
}
