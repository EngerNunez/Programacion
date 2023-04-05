package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class ReporteVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTarjetaMadre;
	private JTextField txtDiscoDuro;
	private JTextField txtRAM;
	private JTextField txtCPU;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteVentas dialog = new ReporteVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteVentas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReporteVentas.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Reporte de Ventas");
		setBounds(100, 100, 482, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			panel.setBounds(0, 0, 482, 248);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblTarjetaMadre = new JLabel("Tarjeta Madre:");
				lblTarjetaMadre.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblTarjetaMadre.setBounds(88, 53, 109, 14);
				panel.add(lblTarjetaMadre);
			}
			{
				JLabel lblDiscoDuro = new JLabel("Disco Duro:");
				lblDiscoDuro.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblDiscoDuro.setBounds(88, 90, 93, 14);
				panel.add(lblDiscoDuro);
			}
			{
				JLabel lblRAM = new JLabel("Memoria RAM:");
				lblRAM.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblRAM.setBounds(88, 126, 93, 14);
				panel.add(lblRAM);
			}
			{
				JLabel lblNewLabel = new JLabel("CPU:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel.setBounds(88, 163, 46, 14);
				panel.add(lblNewLabel);
			}
			{
				txtTarjetaMadre = new JTextField();
				txtTarjetaMadre.setText("0");
				txtTarjetaMadre.setEnabled(false);
				txtTarjetaMadre.setBounds(207, 51, 138, 20);
				panel.add(txtTarjetaMadre);
				txtTarjetaMadre.setColumns(10);
			}
			{
				txtDiscoDuro = new JTextField();
				txtDiscoDuro.setText("0");
				txtDiscoDuro.setEnabled(false);
				txtDiscoDuro.setBounds(207, 88, 138, 20);
				panel.add(txtDiscoDuro);
				txtDiscoDuro.setColumns(10);
			}
			{
				txtRAM = new JTextField();
				txtRAM.setText("0");
				txtRAM.setEnabled(false);
				txtRAM.setBounds(207, 124, 138, 20);
				panel.add(txtRAM);
				txtRAM.setColumns(10);
			}
			{
				txtCPU = new JTextField();
				txtCPU.setText("0");
				txtCPU.setEnabled(false);
				txtCPU.setBounds(207, 161, 138, 20);
				panel.add(txtCPU);
				txtCPU.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Cantidad:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(207, 26, 138, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblTotal = new JLabel("Total:");
				lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblTotal.setBounds(207, 204, 46, 14);
				panel.add(lblTotal);
			}
			{
				txtTotal = new JTextField();
				txtTotal.setText("0");
				txtTotal.setEnabled(false);
				txtTotal.setBounds(248, 202, 97, 20);
				panel.add(txtTotal);
				txtTotal.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.setBackground(new Color(255, 255, 224));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
