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
		setTitle("Reabastecer\r\n");
		setBounds(100, 100, 448, 244);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 152);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de serie:\r\n");
		lblNewLabel.setBounds(10, 11, 96, 14);
		panel.add(lblNewLabel);
		
		txtnumeroSerie = new JTextField();
		txtnumeroSerie.setBounds(109, 8, 136, 20);
		panel.add(txtnumeroSerie);
		txtnumeroSerie.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:\r\n");
		lblMarca.setBounds(10, 55, 70, 14);
		panel.add(lblMarca);
		
		txtmarca = new JTextField();
		txtmarca.setEditable(false);
		txtmarca.setColumns(10);
		txtmarca.setBounds(109, 52, 136, 20);
		panel.add(txtmarca);
		
		JLabel lblAgregarCantidad = new JLabel("Agregar Cantidad:\r\n");
		lblAgregarCantidad.setBounds(10, 95, 96, 14);
		panel.add(lblAgregarCantidad);
		
		spnAgregarCantidad = new JSpinner();
		spnAgregarCantidad.setEnabled(false);
		spnAgregarCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnAgregarCantidad.setBounds(109, 92, 136, 20);
		panel.add(spnAgregarCantidad);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componente compo = TiendaElite.getInstance().buscarComponenteBySerial(txtnumeroSerie.getText());
				if(compo !=  null) {
					txtmarca.setText(compo.getMarca());
					spnAgregarCantidad.enable();
				}else {
					 JOptionPane.showMessageDialog(null,"Debe ingresar un numero serial correto o ingrese un nuevo componente", "ERORR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(263, 7, 89, 23);
		panel.add(btnBuscar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(238, 232, 170));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnReabastecer = new JButton("Reabastecer");
				btnReabastecer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(TiendaElite.getInstance().reabastecer(Integer.valueOf(spnAgregarCantidad.getValue().toString()),txtnumeroSerie.getText()) == true){
							 JOptionPane.showMessageDialog(null,"Se realizo correctamente", "Reabastecer", JOptionPane.WARNING_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"Erorr al realizar el reabastecimiento", "ERORR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnReabastecer.setActionCommand("OK");
				buttonPane.add(btnReabastecer);
				getRootPane().setDefaultButton(btnReabastecer);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
