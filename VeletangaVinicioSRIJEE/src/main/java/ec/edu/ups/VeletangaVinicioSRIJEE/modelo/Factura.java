package ec.edu.ups.VeletangaVinicioSRIJEE.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Factura implements Serializable {
	@Id
	@Column(name = "numerof")
	private String numero;
	private String cedulaCliente;
	private double total;
	private String cuenta;
	private String estado;
	private static final long serialVersionUID = 1L;
	public String getNumero() {
		return numero;
	}
	
	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", cedulaCliente=" + cedulaCliente + ", total=" + total + ", cuenta="
				+ cuenta + ", estado=" + estado + "]";
	}
	 

	
	
	
}
