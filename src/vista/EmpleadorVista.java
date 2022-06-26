package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import modelos.TicketBusquedaEmpleado;
import modelos.TicketBusquedaEmpleo;

public class EmpleadorVista extends JFrame implements IVista {

	private JPanel contentPane;
	private JPanel botones;
	private JPanel cambiarTicketBotonPan;
	private JButton cambiarTicketBoton;
	private JButton activarTicketBoton;
	private JPanel activarTicketBotonPan;
	private JButton mostrarTicketBoton;
	private JPanel mostrarTicketBotonPan;
	private JButton ticketSimplificadoBoton;
	private JPanel ticketSimplificadoPan;
	private JButton agregarTicketBoton;
	private JPanel agregarTicketBotonPan;
	private JList<TicketBusquedaEmpleado> listaTickets;
	private JPanel listaTicketsPan;
	private JPanel ganador;
	private JPanel listaCandidatosPan;
	private JButton elegirGanadorBoton;
	private JPanel elegirGanadorBotonPan;
	private JList<TicketBusquedaEmpleo> listaCandidatos;
	private JButton btnSuspenderTicket;
	private JPanel suspenderTicketBotonPan;
	private JPanel sur;
	private JPanel principal;
	private JButton cerrarSesionBoton;

	/**
	 * Create the frame.
	 */
	public EmpleadorVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		principal = new JPanel();
		contentPane.add(principal, BorderLayout.CENTER);
		principal.setLayout(new GridLayout(0, 3, 0, 0));
		
		botones = new JPanel();
		principal.add(botones);
		botones.setLayout(new GridLayout(6, 1, 0, 0));
		
		agregarTicketBotonPan = new JPanel();
		botones.add(agregarTicketBotonPan);
		
		agregarTicketBoton = new JButton("Agregar Ticket");
		agregarTicketBotonPan.add(agregarTicketBoton);
		
		activarTicketBotonPan = new JPanel();
		botones.add(activarTicketBotonPan);
		
		activarTicketBoton = new JButton("Activar Ticket");
		activarTicketBotonPan.add(activarTicketBoton);
		
		cambiarTicketBotonPan = new JPanel();
		botones.add(cambiarTicketBotonPan);
		
		cambiarTicketBoton = new JButton("Cambiar Ticket");
		cambiarTicketBotonPan.add(cambiarTicketBoton);
		
		suspenderTicketBotonPan = new JPanel();
		botones.add(suspenderTicketBotonPan);
		
		btnSuspenderTicket = new JButton("Suspender Ticket");
		suspenderTicketBotonPan.add(btnSuspenderTicket);
		
		mostrarTicketBotonPan = new JPanel();
		botones.add(mostrarTicketBotonPan);
		
		mostrarTicketBoton = new JButton("Mostrar Ticket");
		mostrarTicketBotonPan.add(mostrarTicketBoton);
		
		ticketSimplificadoPan = new JPanel();
		botones.add(ticketSimplificadoPan);
		
		ticketSimplificadoBoton = new JButton("Ticket Simplificado");
		ticketSimplificadoPan.add(ticketSimplificadoBoton);
		
		listaTicketsPan = new JPanel();
		principal.add(listaTicketsPan);
		
		listaTickets = new JList<>();
		listaTicketsPan.add(listaTickets);
		
		ganador = new JPanel();
		principal.add(ganador);
		ganador.setLayout(new GridLayout(2, 1, 0, 0));
		
		listaCandidatosPan = new JPanel();
		ganador.add(listaCandidatosPan);
		
		listaCandidatos = new JList<>();
		listaCandidatosPan.add(listaCandidatos);
		
		elegirGanadorBotonPan = new JPanel();
		ganador.add(elegirGanadorBotonPan);
		
		elegirGanadorBoton = new JButton("Elegir Ganador");
		elegirGanadorBotonPan.add(elegirGanadorBoton);
		
		sur = new JPanel();
		contentPane.add(sur, BorderLayout.SOUTH);
		
		cerrarSesionBoton = new JButton("Cerrar Sesion");
		sur.add(cerrarSesionBoton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		cambiarTicketBoton.addActionListener(actionListener);
		activarTicketBoton.addActionListener(actionListener);
		mostrarTicketBoton.addActionListener(actionListener);
		ticketSimplificadoBoton.addActionListener(actionListener);
		agregarTicketBoton.addActionListener(actionListener);
		elegirGanadorBoton.addActionListener(actionListener);
	}
	
	public void setFocusListener(FocusListener focusListener ) {
		listaTickets.addFocusListener(focusListener);
	}
	
	public void setListaTickets(ArrayList<TicketBusquedaEmpleado> tickets) {
		DefaultListModel<TicketBusquedaEmpleado> listModel = new DefaultListModel<>();
		for (int i = 0; i < tickets.size(); i++) {
			listModel.add(i, tickets.get(i));
		}
		this.listaTickets = new JList<>(listModel);
		this.listaTickets.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		listaTicketsPan.add(listaTickets);
	}
	
	public TicketBusquedaEmpleado getTicketSeleccionado() {
		return (TicketBusquedaEmpleado)this.listaTickets.getSelectedValue();
	}
	
	public TicketBusquedaEmpleo getCandidatoSeleccionado() {
		return (TicketBusquedaEmpleo)this.listaCandidatos.getSelectedValue();
	}
	
	public void setListaCandidatos(ArrayList<TicketBusquedaEmpleo> tickets) {
		DefaultListModel<TicketBusquedaEmpleo> listModel = new DefaultListModel<>();
		for (int i = 0; i < tickets.size(); i++) {
			listModel.add(i, tickets.get(i));
		}
		this.listaCandidatos = new JList<>(listModel);
		this.listaCandidatos.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		listaCandidatosPan.add(listaTickets);
	}
	
	public void setListaCandidatosVisible(boolean visible) {
		this.listaCandidatos.setVisible(visible);
	}
	
	public boolean isListaCandidatosVisible() {
		return this.listaCandidatos.isVisible();
	}

	@Override
	public void setWindowListener(WindowListener windowListener) {
		// TODO Auto-generated method stub
		
	}
}
