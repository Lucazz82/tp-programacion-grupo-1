package modelos;

import java.util.Date;

import enums.Experiencias;
import enums.PuestosLaborales;

public class EmpleadoPretenso extends Usuario {
	private String nombre;
	private String apellido;
	private String telefono;
	private Date fechaNacimiento;
	/**
	 * Cada empleado tiene un unico ticket. Es inconsistente que tenga 2 al mismo
	 * tiempo.
	 */
	private TicketBusquedaEmpleo ticket;

	public EmpleadoPretenso(String nombreUsuario, String contrasena) {
		super(nombreUsuario, contrasena);
	}

	public EmpleadoPretenso(String nombreUsuario, String contrasena, String nombre, String apellido, String telefono,
			Date fechaNacimiento) {
		super(nombreUsuario, contrasena);
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setTicket(TicketBusquedaEmpleo ticket) {
		this.ticket = ticket;
	}

	public TicketBusquedaEmpleo getTicket() {
		return ticket;
	}

	@Override
	public String toString() {
		return "EmpleadoPretenso [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + ", " + super.toString() + "]";
	}

	@Override
	public void finalizarTicket() {
		this.puntaje += 10;

	}

	@Override
	public void cancelarTicket() {
		this.puntaje--;
	}

	public void puntajeUltimoLugar() {
		this.puntaje -= 5;
	}

	public void puntajePrimerLugar() {
		this.puntaje += 5;
	}

	@Override
	public double calcularComision(Ticket ticket) {
		double porcentaje = 0;
		Formulario formulario = this.ticket.getFormulario();

		switch (formulario.getPuesto()) {
		case GERENCIAL:
			porcentaje = 1;
			break;
		case JUNIOR:
			porcentaje = 0.8;
			break;
		case SENIOR:
			porcentaje = 0.9;
			break;
		default:
			break;
		}

		porcentaje -= this.puntaje * 0.01;
		porcentaje = (porcentaje > 0) ? porcentaje : 0;

		double sueldoPretendido = 0;
		switch (formulario.getRemuneracion()) {
		case ENTRE_V1_V2:
			sueldoPretendido = (formulario.getV2() + formulario.getV1()) / 2;
			break;
		case HASTA_V1:
			sueldoPretendido = formulario.getV1();
			break;
		case MAS_DE_V2:
			sueldoPretendido = formulario.getV2();
			break;
		}

		return sueldoPretendido * porcentaje;
	}
}
