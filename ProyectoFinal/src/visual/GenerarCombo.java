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
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GenerarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenerarCombo dialog = new GenerarCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GenerarCombo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenerarCombo.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Generar Combo");
		setBounds(100, 100, 689, 753);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel PanelPrincipal = new JPanel();
		PanelPrincipal.setBackground(new Color(30, 144, 255));
		PanelPrincipal.setBounds(0, 0, 694, 681);
		contentPanel.add(PanelPrincipal);
		PanelPrincipal.setLayout(null);
		
		JLabel lblCPU = new JLabel("CPU");
		lblCPU.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCPU.setBounds(27, 40, 46, 14);
		PanelPrincipal.add(lblCPU);
		
		JLabel lblDiscoDuro = new JLabel("Disco Duro");
		lblDiscoDuro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiscoDuro.setBounds(27, 191, 89, 14);
		PanelPrincipal.add(lblDiscoDuro);
		
		JLabel lblRAM = new JLabel("RAM");
		lblRAM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRAM.setBounds(27, 342, 46, 14);
		PanelPrincipal.add(lblRAM);
		
		JLabel lblNewLabel = new JLabel("Tarjeta Madre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(27, 493, 125, 14);
		PanelPrincipal.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(27, 65, 152, 115);
		PanelPrincipal.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(27, 216, 152, 115);
		PanelPrincipal.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(27, 367, 152, 115);
		PanelPrincipal.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(27, 518, 152, 115);
		PanelPrincipal.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(344, 78, 299, 555);
		PanelPrincipal.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Combo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(459, 21, 89, 14);
		PanelPrincipal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(474, 646, 46, 14);
		PanelPrincipal.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setBounds(518, 644, 125, 20);
		PanelPrincipal.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Opciones", "Profesor", "Estudiante"}));
		comboBox.setToolTipText("Opciones");
		comboBox.setBounds(344, 47, 299, 20);
		PanelPrincipal.add(comboBox);
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(220, 97, 89, 23);
		PanelPrincipal.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(220, 132, 89, 23);
		PanelPrincipal.add(btnNewButton_1);
		
		JButton button = new JButton("<<");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(220, 280, 89, 23);
		PanelPrincipal.add(button);
		
		JButton button_1 = new JButton(">>");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(220, 246, 89, 23);
		PanelPrincipal.add(button_1);
		
		JButton button_2 = new JButton("<<");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setBounds(220, 430, 89, 23);
		PanelPrincipal.add(button_2);
		
		JButton button_3 = new JButton(">>");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBounds(220, 396, 89, 23);
		PanelPrincipal.add(button_3);
		
		JButton button_4 = new JButton("<<");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setBounds(220, 584, 89, 23);
		PanelPrincipal.add(button_4);
		
		JButton button_5 = new JButton(">>");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_5.setBounds(220, 550, 89, 23);
		PanelPrincipal.add(button_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Generar");
				okButton.setBackground(new Color(255, 255, 224));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(255, 255, 224));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
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
