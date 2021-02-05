package ec.edu.ups.VeletangaVinicioCajeraJEE.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Cliente implements Serializable {
	@Id
	@Column(name="cedula")
	private String cedula;
	private String nombre;
	private String numeroc;
	private static  final long serialVersionUID = 1L;
	public Cliente() {

	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroc() {
		return numeroc;
	}
	public void setNumeroc(String numeroc) {
		this.numeroc = numeroc;
	}
	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", numeroc=" + numeroc + "]";
	} 
	
	
	
	

}
