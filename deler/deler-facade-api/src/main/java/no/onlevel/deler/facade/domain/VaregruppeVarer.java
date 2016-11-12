package no.onlevel.deler.facade.domain;

public class VaregruppeVarer{
	private String varegruppe;
	private String vare;
	
	public VaregruppeVarer(String varegruppe, String vare){
		this.varegruppe = varegruppe;
		this.vare = vare;
	}
	
	public String getVaregruppe() {
		return varegruppe;
	}
	public String getVare() {
		return vare;
	}
	public void setVaregruppe(String varegruppe) {
		this.varegruppe = varegruppe;
	}
	public void setVare(String vare) {
		this.vare = vare;
	}
		
}
