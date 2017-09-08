package Communicacio.Dades;

public class InfoFranjaSetmanal extends InfoDiaSetmana{
	private int id;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "InfoFranjaSetmanal [id=" + id + ", toString()=" + super.toString() + "]";
	}
}
