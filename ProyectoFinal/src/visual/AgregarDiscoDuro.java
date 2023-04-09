package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

import logico.Componente;
import logico.DiscoDuro;
import logico.TiendaElite;

public class AgregarDiscoDuro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtTipoConexion;
	private JTextField txtNumSerie;
	private JSpinner spnPrecio;
	private JSpinner spnCapacidadAlmacenamiento;
	private JSpinner spnCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarDiscoDuro dialog = new AgregarDiscoDuro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarDiscoDuro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarDiscoDuro.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Disco Duro");
		setBounds(100, 100, 428, 329);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblMarca.setBounds(30, 41, 57, 14);
			contentPanel.add(lblMarca);
		}
		{
			JLabel lblModelo = new JLabel("Modelo:");
			lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblModelo.setBounds(30, 66, 81, 14);
			contentPanel.add(lblModelo);
		}
		{
			JLabel lblCapacidadAlmacenamiento = new JLabel("Capacidad de almacenamiento:");
			lblCapacidadAlmacenamiento.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCapacidadAlmacenamiento.setBounds(30, 91, 199, 14);
			contentPanel.add(lblCapacidadAlmacenamiento);
		}
		{
			JLabel lblTipoDeConexion = new JLabel("Tipo de conexion:");
			lblTipoDeConexion.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTipoDeConexion.setBounds(30, 116, 188, 14);
			contentPanel.add(lblTipoDeConexion);
		}
		{
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPrecio.setBounds(30, 141, 46, 14);
			contentPanel.add(lblPrecio);
		}
		{
			JLabel lblNumSerie = new JLabel("Numero de serie:");
			lblNumSerie.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNumSerie.setBounds(30, 166, 112, 14);
			contentPanel.add(lblNumSerie);
		}
		
		txtMarca = new JTextField();
		txtMarca.setBackground(new Color(255, 255, 255));
		txtMarca.setBounds(239, 39, 136, 20);
		contentPanel.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(239, 64, 136, 20);
		contentPanel.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtTipoConexion = new JTextField();
		txtTipoConexion.setBounds(239, 114, 136, 20);
		contentPanel.add(txtTipoConexion);
		txtTipoConexion.setColumns(10);
		
		txtNumSerie = new JTextField();
		txtNumSerie.setBounds(239, 164, 136, 20);
		contentPanel.add(txtNumSerie);
		txtNumSerie.setColumns(10);
		
		spnPrecio = new JSpinner();
		spnPrecio.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnPrecio.setBounds(239, 139, 136, 20);
		contentPanel.add(spnPrecio);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(322, 263, 89, 41);
			contentPanel.add(panel);
		}
		{
			spnCapacidadAlmacenamiento = new JSpinner();
			spnCapacidadAlmacenamiento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnCapacidadAlmacenamiento.setBounds(239, 89, 136, 20);
			contentPanel.add(spnCapacidadAlmacenamiento);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCantidad.setBounds(30, 191, 96, 14);
			contentPanel.add(lblCantidad);
		}
		{
			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCantidad.setBounds(239, 189, 136, 20);
			contentPanel.add(spnCantidad);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 411, 255);
			contentPanel.add(panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.setForeground(new Color(0, 0, 0));
				okButton.setBackground(new Color(255, 255, 224));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Componente aux = null;
						String marca = txtMarca.getText();
						String modelo = txtModelo.getText();
						String tipoconexion = txtTipoConexion.getText();
						String serie = txtNumSerie.getText();
						float precio = Float.valueOf(spnPrecio.getValue().toString());
						float almacenamiento =  Float.valueOf(spnCapacidadAlmacenamiento.getValue().toString());
						int cantidad = Integer.valueOf(spnCantidad.getValue().toString());
						
						aux = new DiscoDuro(marca,serie,precio,cantidad,modelo,almacenamiento,tipoconexion);
						
						TiendaElite.getInstance().insertarComponente(aux);
				
						JOptionPane.showMessageDialog(null, "Disco Disco agregado", "Informacion",JOptionPane.INFORMATION_MESSAGE);
						
						clean();
						
					}
				});
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
	}
	
	private void clean()
	{
		txtMarca.setText("");
		txtModelo.setText("");
		txtTipoConexion.setText("");
		txtNumSerie.setText("");
		spnPrecio.setValue(new Float(0.0));
		spnCapacidadAlmacenamiento.setValue(new Float(0.0));
		spnCantidad.setValue(new Integer(1));
	}
}
