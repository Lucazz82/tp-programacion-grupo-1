package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelos.Usuario;

public class AgenciaVista extends JFrame implements IVista {

	private JPanel contentPane;
	private JPanel principalPan;
	private JPanel cerrarPan;
	private JButton cerrarBoton;
	private JPanel botonesPan;
	private JPanel usuariosPan;
	private JLabel usuariosLabel;
	private JList usuariosLista;
	private JButton generarListasBoton;
	private JPanel generarListasPan;
	private JButton verListasBoton;
	private JPanel verListasPan;
	private JButton rondaContratacionBoton;
	private JPanel rondaContratacionPan;
	private JButton coincidenciasBoton;
	private JPanel coincidenciasPan;


	/**
	 * Create the frame.
	 */
	public AgenciaVista() {
		setTitle("Agencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		principalPan = new JPanel();
		contentPane.add(principalPan, BorderLayout.CENTER);
		principalPan.setLayout(new GridLayout(0, 2, 0, 0));
		
		botonesPan = new JPanel();
		principalPan.add(botonesPan);
		botonesPan.setLayout(new GridLayout(4, 1, 0, 0));
		
		generarListasPan = new JPanel();
		botonesPan.add(generarListasPan);
		
		generarListasBoton = new JButton("Generar Listas de Asignacion");
		generarListasPan.add(generarListasBoton);
		
		verListasPan = new JPanel();
		botonesPan.add(verListasPan);
		
		verListasBoton = new JButton("Ver Listas de Asignacion");
		verListasPan.add(verListasBoton);
		
		rondaContratacionPan = new JPanel();
		botonesPan.add(rondaContratacionPan);
		
		rondaContratacionBoton = new JButton("Iniciar Ronda de Contratacion");
		rondaContratacionPan.add(rondaContratacionBoton);
		
		coincidenciasPan = new JPanel();
		botonesPan.add(coincidenciasPan);
		
		coincidenciasBoton = new JButton("Ver Coincidencias");
		coincidenciasPan.add(coincidenciasBoton);
		
		usuariosPan = new JPanel();
		principalPan.add(usuariosPan);
		usuariosPan.setLayout(new BorderLayout(0, 0));
		
		usuariosLabel = new JLabel("Lista de Usuarios");
		usuariosLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usuariosLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		usuariosPan.add(usuariosLabel, BorderLayout.NORTH);
		
		cerrarPan = new JPanel();
		contentPane.add(cerrarPan, BorderLayout.SOUTH);
		
		cerrarBoton = new JButton("Cerrar Sesion");
		cerrarPan.add(cerrarBoton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}


	@Override
	public void setActionListener(ActionListener actionListener) {
		this.generarListasBoton.addActionListener(actionListener);
		this.verListasBoton.addActionListener(actionListener);
		this.rondaContratacionBoton.addActionListener(actionListener);
		this.coincidenciasBoton.addActionListener(actionListener);
		this.cerrarBoton.addActionListener(actionListener);
	}
	
	public void setListaUsuarios(ArrayList<Usuario> usuarios) {
        DefaultListModel<Usuario> listModel = new DefaultListModel<>();
        this.usuariosLista= new JList<>(listModel);
		this.usuariosLista.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		this.usuariosPan.add(usuariosLista, BorderLayout.CENTER);
        
        for(Usuario usuario : usuarios) {
        	listModel.addElement(usuario);
        }
        
    }


	@Override
	public void setWindowListener(WindowListener windowListener) {
		// TODO Auto-generated method stub
		
	}

}
