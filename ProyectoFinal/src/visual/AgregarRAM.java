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
import logico.MemoriaRAM;
import logico.TiendaElite;

public class AgregarRAM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtTipoMemoria;
	private JTextField txtNumSerie;
	private JSpinner spnPrecio;
	private JSpinner spnCantMemoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarRAM dialog = new AgregarRAM();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarRAM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarRAM.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Memoria RAM");
		setBounds(100, 100, 428, 298);
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
		
		txtNumSerie = new JTextField();
		txtNumSerie.setBounds(239, 164, 136, 20);
		contentPanel.add(txtNumSerie);
		txtNumSerie.setColumns(10);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(322, 263, 89, 41);
			contentPanel.add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 411, 232);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblCantidadMemoria = new JLabel("Cantidad de Memoria:");
				lblCantidadMemoria.setBounds(29, 72, 199, 14);
				panel.add(lblCantidadMemoria);
				lblCantidadMemoria.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			{
				spnCantMemoria = new JSpinner();
				spnCantMemoria.setBounds(238, 70, 136, 20);
				panel.add(spnCantMemoria);
				spnCantMemoria.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			}
			{
				JLabel lblTipoMemoria = new JLabel("Tipo de Memoria:");
				lblTipoMemoria.setBounds(29, 103, 188, 14);
				panel.add(lblTipoMemoria);
				lblTipoMemoria.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
			txtTipoMemoria = new JTextField();
			txtTipoMemoria.setBounds(238, 101, 136, 20);
			panel.add(txtTipoMemoria);
			txtTipoMemoria.setColumns(10);
			{
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(29, 134, 46, 14);
				panel.add(lblPrecio);
				lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
			spnPrecio = new JSpinner();
			spnPrecio.setBounds(238, 132, 136, 20);
			panel.add(spnPrecio);
			spnPrecio.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
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
						float cantmemoria = Float.valueOf(spnCantMemoria.getValue().toString());
						float precio = Float.valueOf(spnPrecio.getValue().toString());
						String tipomemoria = txtTipoMemoria.getText();
						String numserie = txtNumSerie.getText();
						
						aux = new MemoriaRAM(marca,numserie,precio,0, tipomemoria,cantmemoria);
						
						TiendaElite.getInstance().insertarComponente(aux);
						
						JOptionPane.showMessageDialog(null, "Memoria RAM agregada", "Informacion",JOptionPane.INFORMATION_MESSAGE);
						
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
		spnCantMemoria.setValue(new Float(0.0));
		spnPrecio.setValue(new Float(0.0));
		txtTipoMemoria.setText("");
		txtNumSerie.setText("");
	}
	
}