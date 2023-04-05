package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import logico.TiendaElite;
import logico.Componente;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class Reabastecer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtnumeroSerie;
	private JTextField txtmarca;
	private JSpinner spnAgregarCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reabastecer dialog = new Reabastecer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reabastecer() {
		setTitle("Reabastecer");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reabastecer.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setBounds(100, 100, 419, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 433, 170);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de serie:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 123, 14);
		panel.add(lblNewLabel);
		
		txtnumeroSerie = new JTextField();
		txtnumeroSerie.setBounds(143, 9, 136, 20);
		panel.add(txtnumeroSerie);
		txtnumeroSerie.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:\r\n");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMarca.setBounds(10, 55, 70, 14);
		panel.add(lblMarca);
		
		txtmarca = new JTextField();
		txtmarca.setEditable(false);
		txtmarca.setColumns(10);
		txtmarca.setBounds(143, 53, 136, 20);
		panel.add(txtmarca);
		
		JLabel lblAgregarCantidad = new JLabel("Agregar Cantidad:\r\n");
		lblAgregarCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAgregarCantidad.setBounds(10, 95, 123, 14);
		panel.add(lblAgregarCantidad);
		
		spnAgregarCantidad = new JSpinner();
		spnAgregarCantidad.setEnabled(false);
		spnAgregarCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnAgregarCantidad.setBounds(143, 93, 136, 20);
		panel.add(spnAgregarCantidad);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componente compo = TiendaElite.getInstance().buscarComponenteBySerial(txtnumeroSerie.getText());
				if(compo !=  null) {
					txtmarca.setText(compo.getMarca());
					spnAgregarCantidad.enable();
				}else {
					 JOptionPane.showMessageDialog(null,"Debe ingresar un numero serial correcto o ingrese un nuevo componente", "ERORR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(289, 7, 89, 23);
		panel.add(btnBuscar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.info);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnReabastecer = new JButton("Reabastecer");
				btnReabastecer.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnReabastecer.setBackground(SystemColor.info);
				btnReabastecer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(TiendaElite.getInstance().reabastecer(Integer.valueOf(spnAgregarCantidad.getValue().toString()),txtnumeroSerie.getText()) == true){
							 JOptionPane.showMessageDialog(null,"Se realizo correctamente", "Reabastecer", JOptionPane.WARNING_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"Error al realizar el reabastecimiento", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnReabastecer.setActionCommand("OK");
				buttonPane.add(btnReabastecer);
				getRootPane().setDefaultButton(btnReabastecer);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.setBackground(SystemColor.info);
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
}
