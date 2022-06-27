package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import modelos.TicketBusquedaEmpleado;
import modelos.TicketBusquedaEmpleo;
import modelos.TicketOrdenable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;

public class ListaDeAsignacionVista extends JFrame implements IVista {

	private JPanel contentPane;
	private JButton volverBoton;
	private JList ticketsEmpleadorLista;
	private JList ticketsEmpleadoLista;
	private JPanel ticketBusquedaEmpleadoPan;
	private JPanel ticketBusquedaEmpleoPan;
	private JScrollPane ticketBusquedaEmpleadoScrollPan;
	private JScrollPane ticketBusquedaEmpleoScrollPane;
	private DefaultListModel<TicketOrdenable> listModelTicketBusquedaEmpleo;

	public ListaDeAsignacionVista() {
		
		setTitle("Listas de asignacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel sur = new JPanel();
		contentPane.add(sur, BorderLayout.SOUTH);
		
		volverBoton = new JButton("Volver");
		sur.add(volverBoton);
		
		JPanel centro = new JPanel();
		contentPane.add(centro, BorderLayout.CENTER);
		centro.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel listaTicketsBusquedaEmpleadoPan = new JPanel();
		centro.add(listaTicketsBusquedaEmpleadoPan);
		listaTicketsBusquedaEmpleadoPan.setLayout(new BorderLayout(0, 0));
		
		JLabel ticketBusquedaEmpleadoLabel = new JLabel("Tickets busqueda empleado");
		ticketBusquedaEmpleadoLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		ticketBusquedaEmpleadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listaTicketsBusquedaEmpleadoPan.add(ticketBusquedaEmpleadoLabel, BorderLayout.NORTH);
		
		ticketBusquedaEmpleadoPan = new JPanel();
		listaTicketsBusquedaEmpleadoPan.add(ticketBusquedaEmpleadoPan, BorderLayout.CENTER);
		ticketBusquedaEmpleadoPan.setLayout(new BorderLayout(0, 0));
		
		ticketBusquedaEmpleadoScrollPan = new JScrollPane();
		ticketBusquedaEmpleadoPan.add(ticketBusquedaEmpleadoScrollPan, BorderLayout.CENTER);
		
		JPanel listaTicketsBusquedaEmpleoPan = new JPanel();
		centro.add(listaTicketsBusquedaEmpleoPan);
		listaTicketsBusquedaEmpleoPan.setLayout(new BorderLayout(0, 0));
		
		JLabel ticketBusquedaEmpleoLabel = new JLabel("Tickets busqueda empleo");
		ticketBusquedaEmpleoLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		ticketBusquedaEmpleoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listaTicketsBusquedaEmpleoPan.add(ticketBusquedaEmpleoLabel, BorderLayout.NORTH);
		
		ticketBusquedaEmpleoPan = new JPanel();
		listaTicketsBusquedaEmpleoPan.add(ticketBusquedaEmpleoPan, BorderLayout.CENTER);
		ticketBusquedaEmpleoPan.setLayout(new BorderLayout(0, 0));
		
		ticketBusquedaEmpleoScrollPane = new JScrollPane();
		ticketBusquedaEmpleoPan.add(ticketBusquedaEmpleoScrollPane, BorderLayout.CENTER);
		
		listModelTicketBusquedaEmpleo = new DefaultListModel<>();
		ticketsEmpleadoLista = new JList<>(listModelTicketBusquedaEmpleo);
		ticketsEmpleadoLista.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		this.ticketBusquedaEmpleoScrollPane.setViewportView(ticketsEmpleadoLista);
		
		this.setVisible(true);
	}
	
	public void setListaTicketsEmpleadores(ArrayList<TicketBusquedaEmpleado> ticketEmpleadores) {
        DefaultListModel<TicketBusquedaEmpleado> listModel = new DefaultListModel<>();
		ticketsEmpleadorLista = new JList<>(listModel);
		ticketsEmpleadorLista.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		this.ticketBusquedaEmpleadoScrollPan.setViewportView(ticketsEmpleadorLista);
				
        for(TicketBusquedaEmpleado ticket : ticketEmpleadores) {
        	listModel.addElement(ticket);
        }
        
        this.repaint();
    }
	
	public void setListaTicketsEmpleados(List<TicketOrdenable> listaEmpleados) {
		this.listModelTicketBusquedaEmpleo.clear();
        
        for(TicketOrdenable ticket : listaEmpleados) {
        	this.listModelTicketBusquedaEmpleo.addElement(ticket);
        }
        
    }
	
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.volverBoton.addActionListener(actionListener);
	}
	
	public void setFocusListener(FocusListener f) {
		this.ticketsEmpleadorLista.addFocusListener(f);
	}
	
	public TicketBusquedaEmpleado getTicketSeleccionado() {
		return (TicketBusquedaEmpleado)this.ticketsEmpleadorLista.getSelectedValue();
	}

	@Override
	public void setWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);
	}
	
	public void addListSelectionListener(ListSelectionListener listSelectionListener) {
		this.ticketsEmpleadorLista.addListSelectionListener(listSelectionListener);
	}

}
