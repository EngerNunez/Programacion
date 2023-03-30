package logico;

import java.util.ArrayList;

public class TiendaElite {
	
	private ArrayList<Componente>misComponentes;
	private ArrayList<Factura>misFacturas;
	private ArrayList<Cliente>misClientes;
	private ArrayList<Combo>misCombos;
	public static int codigo_componente = 1;
	public static int codigo_factura = 1;
	public static int codigo_combo = 1;
	public static TiendaElite tienda = null;
	
	public TiendaElite() {
		super();
		this.misComponentes = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.misClientes = new ArrayList<>();
		this.misCombos = new ArrayList<>();
	}
	
	public static TiendaElite getInstance()
	{
		if(tienda == null)
		{
			tienda = new TiendaElite();
		}
		return tienda;
	}
	
	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}
	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}
	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}
	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}
	public static int getCodigo_componente() {
		return codigo_componente;
	}
	public static void setCodigo_componente(int codigo_componente) {
		TiendaElite.codigo_componente = codigo_componente;
	}
	public static int getCodigo_factura() {
		return codigo_factura;
	}
	public static void setCodigo_factura(int codigo_factura) {
		TiendaElite.codigo_factura = codigo_factura;
	}
	public static int getCodigo_combo() {
		return codigo_combo;
	}
	public static void setCodigo_combo(int codigo_combo) {
		TiendaElite.codigo_combo = codigo_combo;
	}
	public static TiendaElite getTienda() {
		return tienda;
	}
	public static void setTienda(TiendaElite tienda) {
		TiendaElite.tienda = tienda;
	}
	
	
	
	

}
