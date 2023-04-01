package logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	private ArrayList<Componente>misComponentes;
	private Cliente cliente;
	
	
	public Factura(String codigo, ArrayList<Componente> misComponentes, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.misComponentes = misComponentes;
		this.cliente = cliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public float precioFactura () {
		float precio = 0;
		for(Componente aux: misComponentes) {
			precio += aux.precio;
		}
		return precio;
	}
	
	//a
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
