package modelos;

import java.util.Date;

public class EmpleadoPretenso extends Usuario implements IComision {
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
	public double calcularComision() {
		return this.ticket.getFormulario().getRemuneracion().getSueldoPretendido();
	}

	@Override
	public double calcularPorcentaje() {
		return this.getPuntaje() * 0.01;
	}
}
