package logico;

public abstract class Componente {
	protected String marca;
	protected String numeroSerie;
	protected float precio;
	public Componente(String marca, String numeroSerie, float precio) {
		super();
		this.marca = marca;
		this.numeroSerie = numeroSerie;
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public float getPrecio() {
		return precio;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
