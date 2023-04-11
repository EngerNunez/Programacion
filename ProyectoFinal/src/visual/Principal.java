package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import logico.Control;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	private final Action action_9 = new SwingAction_9();
	private final Action action_10 = new SwingAction_10();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("empresa.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Control.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/Logotipo ELITE ELECTRONICS.png")));
		setTitle("ELITE ELECTRONICS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 50);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnComponentes = new JMenu("Componentes");
		mnComponentes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnComponentes);
		
		JMenuItem mntmAgregarComponentes = mnComponentes.add(action);
		mntmAgregarComponentes.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmAgregarComponentes.setText("Agregar Componentes");
		mntmAgregarComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarComponente agregar_componente = new AgregarComponente();
				agregar_componente.setModal(true);
				agregar_componente.setVisible(true);
			}

		});
		
		JMenuItem mntmReabastecerComponente = mnComponentes.add(action_7);
		mntmReabastecerComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reabastecer reabastecer = new Reabastecer();
				reabastecer.setModal(true);
				reabastecer.setVisible(true);
			}
		});
		mntmReabastecerComponente.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmReabastecerComponente.setText("Reabastecer Componente");
		
		JMenuItem mntmListaDeComponentes = mnComponentes.add(action_1);
		mntmListaDeComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListadoComponente listcomponente = new ListadoComponente();
				listcomponente.setModal(true);
				listcomponente.setVisible(true);
			}
		});
		mntmListaDeComponentes.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmListaDeComponentes.setText("Lista de Componentes");
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnClientes);
		
		JMenuItem mntmListaDeClientes = mnClientes.add(action_2);
		mntmListaDeClientes.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmListaDeClientes.setText("Lista de Clientes");
		mntmListaDeClientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ListaClientes clientes = new ListaClientes();
				clientes.setModal(true);
				clientes.setVisible(true);
				
			}
			
			
		});
		
		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnVentas);
		
		JMenuItem mntmFacturar = mnVentas.add(action_3);
		mntmFacturar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmFacturar.setText("Facturar");
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar facturar = new Facturar();
				facturar.setModal(true);
				facturar.setVisible(true);
			}

		});
		
		
		JMenuItem mntmListaDeFacturas = mnVentas.add(action_4);
		mntmListaDeFacturas.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmListaDeFacturas.setText("Lista de Facturas");
		mntmListaDeFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaFactura listfactura = new ListaFactura();
				listfactura.setModal(true);
				listfactura.setVisible(true);
			}

		});
		
		JMenu mnAdministracion = new JMenu("Administracion");
		if(!Control.getLoginUser().getTipo().equalsIgnoreCase("Administrador")){
			mnAdministracion.setEnabled(false);
		}
		mnAdministracion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmReporteDeVentas = mnAdministracion.add(action_5);
		mntmReporteDeVentas.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmReporteDeVentas.setText("Componentes vendidos");
		mntmReporteDeVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteVentas reporteventas = new ReporteVentas();
				reporteventas.setModal(true);
				reporteventas.setVisible(true);
			}

		});
		
		JMenuItem mntmDineroDeVentas = mnAdministracion.add(action_6);
		mntmDineroDeVentas.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmDineroDeVentas.setText("Dinero generado");
		mntmDineroDeVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DineroVenta dineroventa = new DineroVenta();
				dineroventa.setModal(true);
				dineroventa.setVisible(true);
			}

		});
		
		JMenu mnNewMenu = new JMenu("Usuario");
		if(!Control.getLoginUser().getTipo().equalsIgnoreCase("Administrador")){
			mnNewMenu.setEnabled(false);
		}
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAgregarUsuario = mnNewMenu.add(action_9);
		mntmAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegUsuario rg = new RegUsuario();
				rg.setModal(true);
				rg.setVisible(true);
			}
		});
		mntmAgregarUsuario.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmAgregarUsuario.setText("Agregar Usuario");
		
		JMenu mnNewMenu_1 = new JMenu("Respaldo\r\n");
		if(!Control.getLoginUser().getTipo().equalsIgnoreCase("Administrador")){
			mnNewMenu_1.setEnabled(false);
		}
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmRespaldar = mnNewMenu_1.add(action_10);
		mntmRespaldar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmRespaldar.setText("Respaldar");
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnAyuda);
		
		JMenuItem mntmSugerencias = mnAyuda.add(action_8);
		mntmSugerencias.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmSugerencias.setText("Sugerencias");
		mntmSugerencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ayuda ayuda = new Ayuda();
				ayuda.setModal(true);
				ayuda.setVisible(true);
			}

		});
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/5.png")));
		lblNewLabel.setBounds(0, 0, 1915, 968);
		contentPane.add(lblNewLabel);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "SwingAction_2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "SwingAction_3");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "SwingAction_4");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "SwingAction_5");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "SwingAction_6");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "SwingAction_7");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "SwingAction_8");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "SwingAction_9");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_10 extends AbstractAction {
		public SwingAction_10() {
			putValue(NAME, "SwingAction_10");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}