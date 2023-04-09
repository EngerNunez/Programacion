package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;

import logico.TiendaElite;
import logico.Componente;
import logico.Factura;
import logico.Cliente;
import logico.MemoriaRAM;
import logico.Combo;
import logico.DiscoDuro;
import logico.Microprocesador;
import logico.TarjetaMadre;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;


public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField textField;
	private JScrollPane scrollPaneCompDisponibles;
	private JList ListCompDisponibles;
	private DefaultListModel<String>modelListCompDisponibles;
	private JButton btnComponenteIzquierda;
	private JButton btnComponentesDerecho;
	private JButton btnComboDerecha;
	private JButton btnComboIzquierda;
	private JScrollPane scrollPaneCombos;
	private JList ListCombos;
	private DefaultListModel<String>modelListCombos;
	private JScrollPane scrollPaneCarrito;
	private JList ListCarrito;
	private DefaultListModel<String>modelListCarrito;
	private ArrayList<String>compdisp;
	private ArrayList<String>combosdisp;
	private ArrayList<String>carrito;
	private int selected = -1;
	private float total = 0;
	private int ind = 0;
	
	
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar() {
		
		compdisp = new ArrayList<>();
		combosdisp = new ArrayList<>();
		carrito = new ArrayList<>();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Facturar");
		setBounds(100, 100, 563, 759);
		getContentPane().setLayout(new BorderLayout()); 
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(97, 30, 182, 20);
		txtCodigo.setText("F-"+ TiendaElite.codigo_factura);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(97, 62, 182, 20);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(97, 94, 182, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(96, 123, 423, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(289, 97, 89, 14);
		contentPanel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(360, 94, 159, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = TiendaElite.getInstance().buscarClienteByCedula(txtCedula.getText());
				
				if(cliente != null)
				{
					JOptionPane.showMessageDialog(null, "El cliente se encuentra", "Buscar Cliente",
							JOptionPane.INFORMATION_MESSAGE);
					
					txtNombre.setText(cliente.getNombre());
					txtTelefono.setText(cliente.getTelefono());
					txtDireccion.setText(cliente.getDireccion());
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El cliente no se encuentra", "Buscar Cliente",
							JOptionPane.INFORMATION_MESSAGE);
					
					txtNombre.setEditable(true);
					txtTelefono.setEditable(true);
					txtDireccion.setEditable(true);
				}
				
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setBounds(289, 61, 89, 23);
		contentPanel.add(btnBuscar);
		
		JLabel lblCarritoCompra = new JLabel("Carrito de Compra");
		lblCarritoCompra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCarritoCompra.setBounds(319, 183, 139, 14);
		contentPanel.add(lblCarritoCompra);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 547, 685);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 11, 527, 149);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(10, 22, 70, 21);
		panel_1.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 50, 60, 21);
		panel_1.add(lblCedula);
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 82, 70, 21);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Direccion:");
		lblNewLabel_1.setBounds(10, 114, 70, 14);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 171, 527, 472);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblComponentesDisp = new JLabel("Componentes Disponibles");
		lblComponentesDisp.setBounds(10, 11, 199, 14);
		panel_2.add(lblComponentesDisp);
		lblComponentesDisp.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnComponenteIzquierda = new JButton("<<");
		btnComponenteIzquierda.setBounds(219, 142, 79, 23);
		panel_2.add(btnComponenteIzquierda);
		btnComponenteIzquierda.setEnabled(false);
		btnComponenteIzquierda.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnComponentesDerecho = new JButton(">>");
		btnComponentesDerecho.setBounds(219, 108, 79, 23);
		panel_2.add(btnComponentesDerecho);
		btnComponentesDerecho.setEnabled(false);
		btnComponentesDerecho.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3 = new JLabel("Combos Disponibles");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 245, 199, 14);
		panel_2.add(lblNewLabel_3);
		

		btnComboDerecha = new JButton(">>");
		JPanel PanelCombo = new JPanel();
		PanelCombo.setToolTipText("");
		PanelCombo.setBackground(Color.LIGHT_GRAY);
		PanelCombo.setBounds(10, 278, 199, 183);
		panel_2.add(PanelCombo);
		PanelCombo.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		list.setBounds(0, 191, 199, -190);
		PanelCombo.add(list);
		
		JButton btnComboDerecha = new JButton(">>");
		btnComboDerecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnComboDerecha.setEnabled(false);
		btnComboDerecha.setBounds(219, 325, 79, 23);
		panel_2.add(btnComboDerecha);
		
		btnComboIzquierda = new JButton("<<");
		btnComboIzquierda.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnComboIzquierda.setEnabled(false);
		btnComboIzquierda.setBounds(219, 359, 79, 23);
		panel_2.add(btnComboIzquierda);
		
		JPanel PanelCompDisponibles = new JPanel();
		PanelCompDisponibles.setBounds(10, 41, 188, 193);
		panel_2.add(PanelCompDisponibles);
		PanelCompDisponibles.setLayout(null);
		
		scrollPaneCompDisponibles = new JScrollPane();
		scrollPaneCompDisponibles.setBounds(10, 231, 188, -188);
		panel_2.add(scrollPaneCompDisponibles);
		
		ListCompDisponibles = new JList();
		ListCompDisponibles.setBounds(10, 231, 188, -188);
		panel_2.add(ListCompDisponibles);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 270, 188, 191);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		scrollPaneCombos = new JScrollPane();
		scrollPaneCombos.setBounds(0, 189, 188, -187);
		panel_3.add(scrollPaneCombos);
		
		ListCombos = new JList();
		ListCombos.setBounds(0, 189, 188, -187);
		panel_3.add(ListCombos);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(313, 41, 204, 420);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		scrollPaneCarrito = new JScrollPane();
		scrollPaneCarrito.setBounds(0, 416, 204, -414);
		panel_4.add(scrollPaneCarrito);
		
		ListCarrito = new JList();
		ListCarrito.setBounds(0, 415, 204, -414);
		panel_4.add(ListCarrito);
		
		textField = new JTextField();
		textField.setBounds(367, 654, 158, 20);
		panel.add(textField);
		textField.setEnabled(false);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setBounds(318, 656, 59, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ButtonFacturar = new JButton("Facturar");
				ButtonFacturar.setBackground(new Color(255, 255, 224));
				ButtonFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				ButtonFacturar.setFont(new Font("Tahoma", Font.BOLD, 13));
				ButtonFacturar.setActionCommand("OK");
				buttonPane.add(ButtonFacturar);
				getRootPane().setDefaultButton(ButtonFacturar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(255, 255, 224));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
