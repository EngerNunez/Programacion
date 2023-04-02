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
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

public class AgregarTarjetaMadre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtTipoConector;
	private JTextField txtTipoDiscoCompatible;
	private JTextField txtNumSerie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarTarjetaMadre dialog = new AgregarTarjetaMadre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarTarjetaMadre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarTarjetaMadre.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Tarjeta Madre");
		setBounds(100, 100, 427, 378);
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
			JLabel lblTipoConector = new JLabel("Tipo de conector:");
			lblTipoConector.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTipoConector.setBounds(30, 91, 146, 14);
			contentPanel.add(lblTipoConector);
		}
		{
			JLabel lblTipoMemoria = new JLabel("Tipo de Memoria compatible:");
			lblTipoMemoria.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTipoMemoria.setBounds(30, 116, 199, 14);
			contentPanel.add(lblTipoMemoria);
		}
		{
			JLabel lblTipoDisco = new JLabel("Tipo de Disco compatible:");
			lblTipoDisco.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTipoDisco.setBounds(30, 141, 188, 14);
			contentPanel.add(lblTipoDisco);
		}
		{
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPrecio.setBounds(30, 166, 46, 14);
			contentPanel.add(lblPrecio);
		}
		{
			JLabel lblNumSerie = new JLabel("Numero de serie:");
			lblNumSerie.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNumSerie.setBounds(30, 191, 112, 14);
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
		
		txtTipoConector = new JTextField();
		txtTipoConector.setBounds(239, 89, 136, 20);
		contentPanel.add(txtTipoConector);
		txtTipoConector.setColumns(10);
		
		JTextField txtTipoMemoria = new JTextField();
		txtTipoMemoria.setBounds(239, 114, 136, 20);
		contentPanel.add(txtTipoMemoria);
		txtTipoMemoria.setColumns(10);
		
		txtTipoDiscoCompatible = new JTextField();
		txtTipoDiscoCompatible.setBounds(239, 139, 136, 20);
		contentPanel.add(txtTipoDiscoCompatible);
		txtTipoDiscoCompatible.setColumns(10);
		
		txtNumSerie = new JTextField();
		txtNumSerie.setBounds(239, 189, 136, 20);
		contentPanel.add(txtNumSerie);
		txtNumSerie.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinner.setBounds(239, 164, 136, 20);
		contentPanel.add(spinner);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 411, 304);
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
}
