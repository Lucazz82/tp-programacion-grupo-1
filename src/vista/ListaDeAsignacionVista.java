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

import modelos.TicketBusquedaEmpleado;
import modelos.TicketOrdenable;

public class ListaDeAsignacionVista extends JFrame implements IVista{

	private JPanel contentPane;
	private JButton volverBoton;
	private JList ticketsEmpleadorLista;
	private JList ticketsEmpleadosLista;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ListaDeAsignacionVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		centro.setLayout(new GridLayout(2, 2, 0, 0));
		
		
	}
	
	public void setListaTicketsEmpleadores(ArrayList<TicketBusquedaEmpleado> ticketEmpleadores) {
        DefaultListModel<TicketBusquedaEmpleado> listModel = new DefaultListModel<>();
		ticketsEmpleadorLista = new JList<>(listModel);
		ticketsEmpleadorLista.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        
				
        for(TicketBusquedaEmpleado ticket : ticketEmpleadores) {
        	listModel.addElement(ticket);
        }
        
    }
	
	public void setListaTicketsEmpleados(List<TicketOrdenable> listaEmpleados) {
        DefaultListModel<TicketOrdenable> listModel = new DefaultListModel<>();
        ticketsEmpleadosLista = new JList<>(listModel);
		ticketsEmpleadosLista.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        
        for(TicketOrdenable ticket : listaEmpleados) {
        	listModel.addElement(ticket);
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
		// TODO Auto-generated method stub	
	}

}
