package prueba;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import excepciones.AgenciaInexistenteException;
import excepciones.AgenciaYaExistenteException;
import excepciones.TicketInexistenteException;
import modelos.Agencia;
import modelos.Empleador;
import modelos.TicketBusquedaEmpleado;
import modelos.TicketOrdenable;
import persistencia.AgenciaDTO;
import persistencia.PersistenciaBIN;
import persistencia.UtilDTO;

public class PruebaPersistenciaLectura {
	public static void main(String args[])
			throws ClassNotFoundException, IOException, TicketInexistenteException, AgenciaInexistenteException {
		PersistenciaBIN<AgenciaDTO> persistencia = new PersistenciaBIN<>();
		AgenciaDTO agenciaDTO = persistencia.recuperar("agencia.bin");
		try {
			UtilDTO.agenciaFromAgenciaDTO(agenciaDTO);
		} catch (AgenciaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AgenciaYaExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Agencia agencia = Agencia.getInstancia();

		ArrayList<Empleador> empleadores = agencia.getEmpleadores();

		for (int j = 0; j < empleadores.size(); j++) {
			Empleador empleador = empleadores.get(j);
			Iterator<TicketBusquedaEmpleado> iteradorTickets = empleador.getTickets();

			while (iteradorTickets.hasNext()) {
				TicketBusquedaEmpleado ticket = iteradorTickets.next();
				Iterator<TicketOrdenable> listaAsignacion = agencia.getListaAsignacion(ticket);
				while (listaAsignacion.hasNext()) {
					TicketOrdenable to = listaAsignacion.next();
					System.out.println(to);
					System.out.println("\n");
				}
			}
		}
	}
}
