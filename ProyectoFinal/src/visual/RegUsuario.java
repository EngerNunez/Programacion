package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import logico.Control;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField txtPassword;
	private JTextField txtConfirmarPass;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUsuario() {
		setTitle("Registrar Usuario\r\n");
		setBounds(100, 100, 450, 228);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setBounds(20, 26, 97, 14);
		contentPanel.add(lblNombreUsuario);
		
		textField = new JTextField();
		textField.setBounds(20, 49, 127, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Comercial"}));
		comboBox.setBounds(20, 113, 127, 20);
		contentPanel.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(20, 88, 97, 14);
		contentPanel.add(lblTipo);
		
		JPasswordField passwordField = new JPasswordField(20);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(190, 49, 147, 20);
		contentPanel.add(txtPassword);
		txtPassword.setColumns(10);
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(189, 26, 97, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
		lblConfirmarPassword.setBounds(189, 88, 167, 14);
		contentPanel.add(lblConfirmarPassword);
		
		txtConfirmarPass = new JTextField();
		txtConfirmarPass.setColumns(10);
		txtConfirmarPass.setBounds(190, 113, 147, 20);
		contentPanel.add(txtConfirmarPass);
		
		
		 
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user = new User(comboBox.getSelectedItem().toString(),textField.getText(),txtPassword.getText());
					    Control.getInstance().regUser(user);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
