package Domini.Model.Calendaris;

import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoFranjaSetmanal;
import Communicacio.Excepcions.DadaIncorrecta;

public class FranjaSetmanal {
	private int id;
	protected LocalTime start;
	protected LocalTime end;
	protected int diaSetmana;
	public FranjaSetmanal(){
		
	}
	public LocalTime getStart() {
		return start;
	}
	public void setStart(LocalTime start) {
		this.start = start;
	}
	public LocalTime getEnd() {
		return end;
	}
	public void setEnd(LocalTime end) {
		this.end = end;
	}
	public int getDiaSetmana() {
		return diaSetmana;
	}
	public void setDiaSetmana(int diaSetmana) {
		this.diaSetmana = diaSetmana;
	}
	public int getId() {
		return id;
	}
	public void setId(int idFranjaSetmanal) {
		this.id = idFranjaSetmanal;
	}
	public boolean mateixDiaSetmana(LocalDate dia){
		return this.diaSetmana == dia.getDayOfWeek();
	}
	
	public Interval crearInterval(LocalDate dia){
		return new Interval(dia.toDateTime(start),dia.toDateTime(end));
	}
	public InfoFranjaSetmanal toInfo() {
		InfoFranjaSetmanal ret = new InfoFranjaSetmanal();
		ret.setId(this.id);
		ret.setInici(this.start);
		ret.setFi(this.end);
		ret.setDiaSetmana(this.diaSetmana);
		return ret;
	}
	
	public void populate(InfoFranjaSetmanal info) throws DadaIncorrecta{
		if (info.getId() != 0) this.setId(info.getId());
		if (info.getInici() != null) this.setStart(info.getInici());
		if (info.getFi() != null) this.setEnd(info.getFi());
		if (info.getDiaSetmana() != 0) this.setDiaSetmana(info.getDiaSetmana());
	}
	
	public void populate(InfoDiaSetmana info) throws DadaIncorrecta{
		if (info.getInici() != null) this.setStart(info.getInici());
		if (info.getFi() != null) this.setEnd(info.getFi());
		if (info.getDiaSetmana() != 0) this.setDiaSetmana(info.getDiaSetmana());
	}
	
}
