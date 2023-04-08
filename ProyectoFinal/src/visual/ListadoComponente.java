package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.TiendaElite;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javafx.scene.control.SelectionMode;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ListadoComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JComboBox cbxTarjetaMadre;
	private JComboBox cbxEstado;
	private JTable table;
	private Object rows[];
	private Componente selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoComponente dialog = new ListadoComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoComponente() {
		setTitle("Lista de componente\r\n");
		setBounds(100, 100, 667, 422);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(30, 144, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 96, 626, 236);
		contentPanel.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if(index >= 0) {
					String codigo = table.getValueAt(index, 0).toString();
					selected = TiendaElite.getInstance().buscarComponenteBySerial(codigo);
				}
			}
		});
		scrollPane.setBounds(0, 0, 626, 236);
		panel.add(scrollPane,BorderLayout.CENTER);
		{
			String[] headers = {"Numero de Serie","Marca","Precio","Disponibilidad"};
			
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			table.setModel(model);
		}

		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 626, 74);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Estado:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(355, 17, 79, 36);
		panel_1.add(lblNewLabel_1);

		cbxTarjetaMadre = new JComboBox();
		cbxTarjetaMadre.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbxTarjetaMadre.setModel(new DefaultComboBoxModel(
				new String[] { "<Todos>", "Tarjeta Madre", "Memoria RAM", "Disco Duro", "Microprocesador" }));
		cbxTarjetaMadre.setBounds(92, 24, 158, 25);
		panel_1.add(cbxTarjetaMadre);

		JLabel lblTipo = new JLabel("Tipo:\r\n");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(35, 17, 47, 36);
		panel_1.add(lblTipo);
		//prueba
		cbxEstado = new JComboBox();
		cbxEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] { "<Todos>", "Disponible", "Critico" }));
		cbxEstado.setBounds(431, 24, 158, 25);
		panel_1.add(cbxEstado);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton btnEliminar = new JButton("Eliminar\r\n");
			btnEliminar.setBackground(new Color(255, 255, 224));
			btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnEliminar.setActionCommand("OK");
			buttonPane.add(btnEliminar);
			{
				JButton okButton = new JButton("Modificar\r\n");
				okButton.setBackground(new Color(255, 255, 224));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(255, 255, 224));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadComponentes(0);
	}

	public void loadComponentes(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if (index == 0) {
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getPrecio();
					rows[3] = aux.getDisponibilidad();
					if (aux instanceof TarjetaMadre) {
						rows[4] = "Tarjeta Madre";
					}
					if (aux instanceof DiscoDuro) {
						rows[4] = "Disco Duro";
					}
					if (aux instanceof Microprocesador) {
						rows[4] = "Microprocesador";
					}
					if (aux instanceof MemoriaRAM) {
						rows[4] = "Memoria RAM";
					}
			}
		}
		if (index == 1) {
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				if (aux instanceof TarjetaMadre && aux.getDisponibilidad() == 'D') {
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getPrecio();
					rows[3] = aux.getDisponibilidad();
					model.addRow(rows);
				}
				if (aux instanceof TarjetaMadre && aux.getDisponibilidad() == 'C') {
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getPrecio();
					rows[3] = aux.getDisponibilidad();
					model.addRow(rows);
				}
			}
		}
		if (index == 2) {
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				if (aux instanceof MemoriaRAM && aux.getDisponibilidad() == 'D') {
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getPrecio();
					rows[3] = aux.getDisponibilidad();
					model.addRow(rows);
				}
				if (aux instanceof MemoriaRAM && aux.getDisponibilidad() == 'C') {
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getPrecio();
					rows[3] = aux.getDisponibilidad();
					model.addRow(rows);
				}
			}
		}
		if (index == 3) {
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				if (aux instanceof DiscoDuro && aux.getDisponibilidad() == 'D') {
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getPrecio();
					rows[3] = aux.getDisponibilidad();
					model.addRow(rows);
				}
				if (aux instanceof DiscoDuro && aux.getDisponibilidad() == 'C') {
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getPrecio();
					rows[3] = aux.getDisponibilidad();
					model.addRow(rows);
				}
			}
		}
		if (index == 4) {
			for (Componente aux : TiendaElite.getInstance().getMisComponentes()) {
				if (aux instanceof Microprocesador && aux.getDisponibilidad() == 'D') {
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getPrecio();
					rows[3] = aux.getDisponibilidad();
					model.addRow(rows);
				}
				if (aux instanceof Microprocesador && aux.getDisponibilidad() == 'C') {
					rows[0] = aux.getNumeroSerie();
					rows[1] = aux.getMarca();
					rows[2] = aux.getPrecio();
					rows[3] = aux.getDisponibilidad();
					model.addRow(rows);
				}
			}
		}
	}
}
