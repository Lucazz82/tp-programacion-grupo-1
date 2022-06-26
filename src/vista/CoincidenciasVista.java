package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelos.Coincidencia;
import modelos.Usuario;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class CoincidenciasVista extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel principal;
	private JPanel volverPan;
	private JButton volverBoton;
	private JList coincidenciasLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoincidenciasVista frame = new CoincidenciasVista();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoincidenciasVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		principal = new JPanel();
		contentPane.add(principal, BorderLayout.CENTER);
		
		coincidenciasLista = new JList();
		principal.add(coincidenciasLista);
		
		volverPan = new JPanel();
		contentPane.add(volverPan, BorderLayout.SOUTH);
		
		volverBoton = new JButton("Volver");
		volverPan.add(volverBoton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.volverBoton.addActionListener(actionListener);
	}
	
	public void setListaCoincidencias(ArrayList<Coincidencia> coincidencias) {
        DefaultListModel<Coincidencia> listModel = new DefaultListModel<>();
        coincidenciasLista = new JList(listModel);
		principal.add(coincidenciasLista);
        
        for(Coincidencia coincidencia : coincidencias) {
        	listModel.addElement(coincidencia);
        }
        
    }

	@Override
	public void setWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);
		
	}

}
