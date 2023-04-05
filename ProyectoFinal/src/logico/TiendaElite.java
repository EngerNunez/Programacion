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
	
	public void insertarComponente(Componente componente) {
		misComponentes.add(componente);
		codigo_componente++;
	}
	
	public void insertarFactura(Factura factura) {
		misFacturas.add(factura);
		codigo_factura++;
	}
	public void insertarClientes(Cliente cliente) {
		misClientes.add(cliente);
	}
	
	public void insertarCombo(Combo combo) {
		misCombos.add(combo);
		codigo_combo++;
	}
	
	public int cantTarjetaMadreVendido() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof TarjetaMadre)
				cant++;
		}
		return cant;
	}
	
	public int cantDiscoDuroVendido() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof DiscoDuro)
				cant++;
		}
		return cant;
	}
	
	public int cantMemoriaRAMVendido() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof MemoriaRAM)
				cant++;
		}
		return cant;
	}
	
	public int cantCPUVendido() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof Microprocesador)
				cant++;
		}
		return cant;
	}
	
	public float dineroTotalGenerado() {
		float total = 0;
		for(Factura aux: misFacturas) {
			total += aux.precioFactura();
		}
		return total;
		//retorna la cantidad de dinero vendido en la tienda
	}
	
	public Cliente buscarClienteByCedula(String cedula) {
		Cliente aux = null;
		boolean encontrado = false;
		for (Cliente cliente : misClientes) {
			if (cliente.getCedula().equalsIgnoreCase(cedula)) {
				aux = cliente;
				encontrado = true;
			}
		}
		return aux;
	}
	
	public Componente buscarComponenteBySerial(String codigo) {
		Componente aux = null;
		boolean encontrado = false;
		for(Componente componente: misComponentes) {
			if(componente.getNumeroSerie().equalsIgnoreCase(codigo)) {
				encontrado = true;
				aux = componente;
			}
		}
		return aux;
	}
	
	public boolean reabastecer (int cantidad , String serial) {
		Componente componente = buscarComponenteBySerial(serial);
		boolean realizado = false;
		if( componente != null) {
			for(int i=0; i<cantidad;i++) {
				insertarComponente(componente);
				realizado = true;
			}
			
		}
		return realizado;
	}
	
	
	
	
	

}
