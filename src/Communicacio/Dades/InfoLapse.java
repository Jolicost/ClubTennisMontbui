package Communicacio.Dades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import Communicacio.Excepcions.DadaIncorrecta;
import Communicacio.Excepcions.EntitatInvalida;

public class InfoLapse extends Info implements Comparable<InfoLapse>,Comparator<InfoLapse>{
	public InfoLapse(){}
	public InfoLapse(Interval i) {
		this.i = i;
	}
	protected Interval i;
	
	public Interval getInterval(){return i;}
	public void setInterval(Interval i){this.i = i;}

	public LocalDate getDia(){
		return i.getStart().toLocalDate();
	}

	public LocalTime getInici(){
		return i.getStart().toLocalTime();
	}
	public LocalTime getFi(){
		return i.getEnd().toLocalTime();
	}
	
	public String getIniciFormat(){
		DateTimeFormatter d = DateTimeFormat.forPattern("HH:mm");
		return d.print(this.getInici());
	}
	public String getFiFormat(){
		DateTimeFormatter d = DateTimeFormat.forPattern("HH:mm");
		return d.print(this.getFi());
	}
	public String getDiaFormat(){
		DateTimeFormatter d = DateTimeFormat.forPattern("dd/MM/yyyy");
		return d.print(this.getDia());
	}
	@Override
	public int compareTo(InfoLapse o) {
		return i.getStart().compareTo(o.i.getStart());
	}
	@Override
	public String toString() {
		return i.toString() + "\n";
	}
	
	public String getTitol(){
		return "Lapse";
	}
	public InfoLapse toInfoLapse() throws DadaIncorrecta{
		return this;
	}
	
	public List<String> getAttributeNames(){
		List<String> ret = new ArrayList<>();
		ret.add("Inici");
		ret.add("Fi");
		return ret;
	}
	
	
	public List<String> getAttributeValues(){
		List<String> ret = new ArrayList<>();
		ret.add(this.i.getStart().toString());
		ret.add(this.i.getEnd().toString());
		return ret;
	}
	
	public Info Populate(Map<String,String[]> params) throws IllegalArgumentException, IllegalAccessException, EntitatInvalida{	
		DateTime i1 = DateTime.parse(params.get("inici")[0]);
		DateTime i2 = DateTime.parse(params.get("fi")[0]);
		
		Interval i = new Interval(i1,i2);
		this.setInterval(i);	
		return this;
	}
	@Override
	public int compare(InfoLapse o1, InfoLapse o2) {
		return o1.compareTo(o2);
	}

	
	
}
