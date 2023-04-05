package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Color;

public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField textField;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Facturar");
		setBounds(100, 100, 551, 547);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(97, 30, 182, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(97, 62, 182, 20);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(97, 94, 182, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setBounds(96, 123, 416, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(289, 97, 89, 14);
		contentPanel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(360, 94, 152, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setBounds(289, 61, 89, 23);
		contentPanel.add(btnBuscar);
		
		JLabel lblCarritoCompra = new JLabel("Carrito de Compra");
		lblCarritoCompra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCarritoCompra.setBounds(319, 183, 139, 14);
		contentPanel.add(lblCarritoCompra);
		
		JList ListCompDisponibles = new JList();
		ListCompDisponibles.setBounds(10, 389, 199, -179);
		contentPanel.add(ListCompDisponibles);
		
		JPanel PanelCarritoCompra = new JPanel();
		PanelCarritoCompra.setBackground(Color.LIGHT_GRAY);
		PanelCarritoCompra.setBounds(319, 209, 199, 183);
		contentPanel.add(PanelCarritoCompra);
		
		JList ListCarritoCompra = new JList();
		ListCarritoCompra.setBounds(319, 389, 193, -179);
		contentPanel.add(ListCarritoCompra);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(319, 420, 59, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(360, 418, 158, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 535, 502);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 11, 515, 149);
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
		panel_2.setBounds(10, 171, 515, 237);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel PanelComponentesDisponibles = new JPanel();
		PanelComponentesDisponibles.setForeground(new Color(255, 255, 255));
		PanelComponentesDisponibles.setBounds(10, 43, 199, 183);
		panel_2.add(PanelComponentesDisponibles);
		PanelComponentesDisponibles.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblComponentesDisp = new JLabel("Componentes Disponibles");
		lblComponentesDisp.setBounds(10, 11, 199, 14);
		panel_2.add(lblComponentesDisp);
		lblComponentesDisp.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.setBounds(219, 142, 79, 23);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.setBounds(219, 108, 79, 23);
		panel_2.add(btnNewButton);
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
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
