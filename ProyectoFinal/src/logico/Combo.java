package logico;

import java.util.ArrayList;

public class Combo {
	
	private String codigo;
	private ArrayList<Componente>misComponentes;

	public Combo(String codigo, ArrayList<Componente> misComponentes) {
		super();
		this.codigo = codigo;
		this.misComponentes = misComponentes;
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
	
	
	
	

}
