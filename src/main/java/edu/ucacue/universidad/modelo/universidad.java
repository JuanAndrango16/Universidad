package edu.ucacue.universidad.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
public class universidad {
	 
	//ORM es mapeo objetyo relacional. 
	@Entity
	@Table(name="personas_table")
	public class persona {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name = "nombre_da",columnDefinition = "text")
		private String nombre;
		
		@Column(length = 30)
		private String descripcion ;
		@Column(length = 30)
		private String dieccion;
		@Column(length = 30)
		private String telefono;
		@Column(length = 30)
		private String numerodeestudiantes;
		@Column(length = 30)
		private String correoelectronico;
		
		public persona(int id, String nombre, String descripcion, String dieccion, String telefono,
				String numerodeestudiantes, String correoelectronico) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.dieccion = dieccion;
			this.telefono = telefono;
			this.numerodeestudiantes = numerodeestudiantes;
			this.correoelectronico = correoelectronico;
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getDieccion() {
			return dieccion;
		}

		public void setDieccion(String dieccion) {
			this.dieccion = dieccion;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getNumerodeestudiantes() {
			return numerodeestudiantes;
		}

		public void setNumerodeestudiantes(String numerodeestudiantes) {
			this.numerodeestudiantes = numerodeestudiantes;
		}

		public String getCorreoelectronico() {
			return correoelectronico;
		}

		public void setCorreoelectronico(String correoelectronico) {
			this.correoelectronico = correoelectronico;
		}

		 
	}

}
