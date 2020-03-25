package Buscaminas;

public class Casilla {
	private Estado estado;
	private String infoCasilla ;
	
	public Casilla(String info) {
		this.estado=new Tapado();
		this.infoCasilla=info;
	}
	public int clickIzq() {
		return this.estado.clickIzq(this);
	}
	public int clickDer() {
		return this.estado.clickDer(this);
	}
	public void cambiarEstado(Estado pEstado) {
		this.estado=pEstado;
	}
	public String getInfoCasilla() {
		return this.infoCasilla;
	}
}
