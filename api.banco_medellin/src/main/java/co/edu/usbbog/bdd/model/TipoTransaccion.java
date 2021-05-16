package co.edu.usbbog.bdd.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoTransaccion {
	@Id
	private long id;
	private String nombre;
	
	public TipoTransaccion(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public TipoTransaccion() {
		super();
		this.id = 0;
		this.nombre = "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoTransaccion other = (TipoTransaccion) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoTransaccion [id=" + id + ", nombre=" + nombre + "]";
	}

	
}
