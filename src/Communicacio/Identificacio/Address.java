package Communicacio.Identificacio;

public class Address {
	private String ip;
	private int port;
	
	public Address(String ip,int port){
		this.ip = ip;
		this.port = port;
	}


	@Override
	public boolean equals(Object obj) {
		Address o =  (Address) obj;
		return (o.ip.equals(ip) && o.port == port);
	}
}
