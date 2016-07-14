package Communicacio.Dades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import Communicacio.Excepcions.DadaIncorrecta;

public class InfoObertura extends InfoLapse{

	public LocalDate dia;
	
	public InfoObertura(){
		
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	
	public List<String> getAttributeNames(){
		List<String> ret = super.getAttributeNames();
		ret.add(0,"Dia");
		return ret;
	}
	
	public InfoObertura toInfoObertura() throws DadaIncorrecta{
		return this;
	}
	
	public List<String> getAttributeValues(){
		List<String> ret = new ArrayList<>();
		ret.add(dia.toString());
		ret.add(getInici().toString());
		ret.add(getFi().toString());
		return ret;
	}
	
	public LocalTime getInici(){
		return super.getInterval().getStart().toLocalTime();
	}
	public LocalTime getFi(){
		return super.getInterval().getEnd().toLocalTime();
	}
	
	public Info Populate(Map<String,String[]> params) throws IllegalArgumentException, IllegalAccessException{
		LocalTime i1 = LocalTime.parse(params.get("inici")[0]);
		LocalTime i2 = LocalTime.parse(params.get("fi")[0]);
		
		LocalDate dia = LocalDate.parse(params.get("dia")[0]);
		
		DateTime l1 = dia.toDateTime(i1);
		DateTime l2 = dia.toDateTime(i2);
		
		Interval i = new Interval(l1,l2);
		this.setInterval(i);	
		this.setDia(dia);
		return this;
	}
	
}
