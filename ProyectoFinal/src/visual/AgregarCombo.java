package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.TiendaElite;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Choice;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class AgregarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField txtCodigo;
	
	private JScrollPane scrollPaneCPU;
	private JScrollPane scrollPaneSSD;
	private JScrollPane scrollPaneRAM;
	private JScrollPane scrollPaneMB;
	private JScrollPane scrollPaneCombo;
	
	private JList ListCPU;
	private JList ListSSD;
	private JList ListRAM;
	private JList ListMB;
	private JList ListCombo;
	
	private JButton btnDerechaCPU;
	private JButton btnIzquierdaCPU;
	private JButton btnIzquierdaSSD;
	private JButton btnDerechaSSD;
	private JButton btnIzquierdaRAM;
	private JButton btnDerechaRAM;
	private JButton btnIzquierdaMB;
	private JButton btnDerechaMB;
	
	private DefaultListModel<String>modelListCPU;
	private DefaultListModel<String>modelListSSD;
	private DefaultListModel<String>modelListRAM;
	private DefaultListModel<String>modelListMB;
	private DefaultListModel<String>modelListCombo;
	
	private ArrayList<String>CPU;
	private ArrayList<String>SSD;
	private ArrayList<String>RAM;
	private ArrayList<String>MB;
	private ArrayList<String>Combo;
	
	private int selected = -1;
	private float total = 0;
	private int ind = 0;
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarCombo dialog = new AgregarCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarCombo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarCombo.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("Agregar Combo");
		setBounds(100, 100, 683, 753);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel PanelPrincipal = new JPanel();
		PanelPrincipal.setBackground(new Color(30, 144, 255));
		PanelPrincipal.setBounds(0, 0, 673, 681);
		contentPanel.add(PanelPrincipal);
		PanelPrincipal.setLayout(null);
		
		JLabel lblCPU = new JLabel("CPU");
		lblCPU.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCPU.setBounds(27, 40, 46, 20);
		PanelPrincipal.add(lblCPU);
		
		JLabel lblDiscoDuro = new JLabel("Disco Duro");
		lblDiscoDuro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiscoDuro.setBounds(27, 191, 89, 20);
		PanelPrincipal.add(lblDiscoDuro);
		
		JLabel lblRAM = new JLabel("RAM");
		lblRAM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRAM.setBounds(27, 342, 46, 20);
		PanelPrincipal.add(lblRAM);
		
		JLabel lblNewLabel = new JLabel("Tarjeta Madre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(27, 493, 125, 20);
		PanelPrincipal.add(lblNewLabel);
		
		JPanel PanelCPU = new JPanel();
		PanelCPU.setBackground(new Color(255, 255, 255));
		PanelCPU.setBounds(27, 65, 181, 115);
		PanelPrincipal.add(PanelCPU);
		PanelCPU.setLayout(null);
		
		scrollPaneCPU = new JScrollPane();
		PanelCPU.add(scrollPaneCPU, BorderLayout.CENTER);
		
		ListCPU = new JList<>();
		ListCPU.setBounds(0, 112, 181, -110);
		ListCPU.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = ListCPU.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnDerechaCPU.setEnabled(true);
					btnIzquierdaCPU.setEnabled(false);
				}
			}
			
		});
		
		modelListCPU = new DefaultListModel<String>();
		ListCPU.setModel(modelListCPU);
		ListCPU.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPaneCPU.setViewportView(ListCPU);

		
		
		JPanel PanelSSD = new JPanel();
		PanelSSD.setBackground(new Color(255, 255, 255));
		PanelSSD.setBounds(27, 216, 181, 115);
		PanelPrincipal.add(PanelSSD);
		PanelSSD.setLayout(null);
		
		scrollPaneSSD = new JScrollPane();
		PanelSSD.add(scrollPaneSSD, BorderLayout.CENTER);
		
		ListSSD = new JList<>();
		ListSSD.setBounds(0, 112, 181, -110);
		ListSSD.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = ListSSD.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnDerechaSSD.setEnabled(true);
					btnIzquierdaSSD.setEnabled(false);
				}
			}
			
		});
		
		modelListSSD = new DefaultListModel<String>();
		ListSSD.setModel(modelListSSD);
		ListSSD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPaneSSD.setViewportView(ListSSD);
		
		JPanel PanelRAM = new JPanel();
		PanelRAM.setBackground(new Color(255, 255, 255));
		PanelRAM.setBounds(27, 367, 181, 115);
		PanelPrincipal.add(PanelRAM);
		PanelRAM.setLayout(null);
		
		scrollPaneRAM = new JScrollPane();
		PanelRAM.add(scrollPaneRAM, BorderLayout.CENTER);
		
		
		ListRAM = new JList<>();
		ListRAM.setBounds(0, 114, 181, -110);
		ListRAM.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = ListRAM.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnDerechaRAM.setEnabled(true);
					btnIzquierdaRAM.setEnabled(false);
				}
			}
			
		});
		
		modelListRAM = new DefaultListModel<String>();
		ListRAM.setModel(modelListRAM);
		ListRAM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPaneRAM.setViewportView(ListRAM);
		
		JPanel PanelMB = new JPanel();
		PanelMB.setBackground(new Color(255, 255, 255));
		PanelMB.setBounds(27, 518, 181, 115);
		PanelPrincipal.add(PanelMB);
		PanelMB.setLayout(null);
		
		scrollPaneMB = new JScrollPane();
		PanelMB.add(scrollPaneMB, BorderLayout.CENTER);

		ListMB = new JList<>();
		ListMB.setBounds(0, 118, 181, -117);
		ListMB.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = ListMB.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnDerechaMB.setEnabled(true);
					btnIzquierdaMB.setEnabled(false);
				}
			}
			
		});
		
		modelListMB = new DefaultListModel<String>();
		ListMB.setModel(modelListMB);
		ListMB.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPaneMB.setViewportView(ListMB);
		
		JPanel PanelCombo = new JPanel();
		PanelCombo.setBackground(new Color(255, 255, 255));
		PanelCombo.setBounds(344, 78, 299, 555);
		PanelPrincipal.add(PanelCombo);
		PanelCombo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Combo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(460, 21, 61, 14);
		PanelPrincipal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(460, 646, 46, 14);
		PanelPrincipal.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setText("$0.0");
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setBounds(503, 644, 140, 20);
		PanelPrincipal.add(textField);
		textField.setColumns(10);
		
		JComboBox cbxOpciones = new JComboBox();
		cbxOpciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbxOpciones.setModel(new DefaultComboBoxModel(new String[] {"Combo Normal", "Combo Profesor", "Combo Estudiante"}));
		cbxOpciones.setToolTipText("Opciones");
		cbxOpciones.setBounds(344, 47, 299, 20);
		PanelPrincipal.add(cbxOpciones);
		
		btnDerechaCPU = new JButton(">>");
		btnDerechaCPU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnDerechaCPU.setEnabled(false);
		btnDerechaCPU.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDerechaCPU.setBounds(232, 97, 89, 23);
		PanelPrincipal.add(btnDerechaCPU);
		
		btnIzquierdaCPU = new JButton("<<");
		btnIzquierdaCPU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIzquierdaCPU.setEnabled(false);
		btnIzquierdaCPU.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIzquierdaCPU.setBounds(232, 134, 89, 23);
		PanelPrincipal.add(btnIzquierdaCPU);
		
		btnIzquierdaSSD = new JButton("<<");
		btnIzquierdaSSD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIzquierdaSSD.setEnabled(false);
		btnIzquierdaSSD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIzquierdaSSD.setBounds(232, 280, 89, 23);
		PanelPrincipal.add(btnIzquierdaSSD);
		
		btnDerechaSSD = new JButton(">>");
		btnDerechaSSD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDerechaSSD.setEnabled(false);
		btnDerechaSSD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDerechaSSD.setBounds(232, 246, 89, 23);
		PanelPrincipal.add(btnDerechaSSD);
		
		btnIzquierdaRAM = new JButton("<<");
		btnIzquierdaRAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIzquierdaRAM.setEnabled(false);
		btnIzquierdaRAM.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIzquierdaRAM.setBounds(232, 430, 89, 23);
		PanelPrincipal.add(btnIzquierdaRAM);
		
		btnDerechaRAM = new JButton(">>");
		btnDerechaRAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDerechaRAM.setEnabled(false);
		btnDerechaRAM.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDerechaRAM.setBounds(232, 396, 89, 23);
		PanelPrincipal.add(btnDerechaRAM);
		
		btnIzquierdaMB = new JButton("<<");
		btnIzquierdaMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIzquierdaMB.setEnabled(false);
		btnIzquierdaMB.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIzquierdaMB.setBounds(232, 585, 89, 23);
		PanelPrincipal.add(btnIzquierdaMB);
		
		btnDerechaMB = new JButton(">>");
		btnDerechaMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDerechaMB.setEnabled(false);
		btnDerechaMB.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDerechaMB.setBounds(232, 550, 89, 23);
		PanelPrincipal.add(btnDerechaMB);
		
		scrollPaneCombo = new JScrollPane();
		scrollPaneCombo.setBounds(344, 78, 297, 555);
		PanelPrincipal.add(scrollPaneCombo);
		
		ListCombo = new JList<>();
		ListCombo.setBounds(643, 78, -298, 555);
        ListCombo.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				selected = ListCombo.getSelectedIndex();
				
				if(selected >= 0)
				{
					btnDerechaCPU.setEnabled(false);
					btnIzquierdaCPU.setEnabled(true);
					
					btnIzquierdaSSD.setEnabled(true);
					btnDerechaSSD.setEnabled(false);
					
			      	btnIzquierdaRAM.setEnabled(true);
					btnDerechaRAM.setEnabled(false);
					
					btnIzquierdaMB.setEnabled(true);
					btnDerechaMB.setEnabled(false);
				}
			}
			
		});
		
		modelListCombo = new DefaultListModel<String>();
		ListCombo.setModel(modelListMB);
		ListCombo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPaneCombo.setViewportView(ListCombo);
		
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(27, 11, 74, 18);
		PanelPrincipal.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(87, 12, 121, 20);
		txtCodigo.setText("C-"+TiendaElite.codigo_combo);
		PanelPrincipal.add(txtCodigo);
		txtCodigo.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 224));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
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
