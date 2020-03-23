public class Casilla {
	private Estado estado;
	private int infoCasilla;
	
	public Casilla(Estado est,int info) {
		this.estado=est;
		this.infoCasilla=info;
	}
	public int clickIzq() {
		this.estado.clickIzq(this);
	}
	public int clickDer() {
		this.estado.clickDer(this);
	}
	public void cambiarEstado(Estado pEstado) {
		this.estado=pEstado;
	}
}
