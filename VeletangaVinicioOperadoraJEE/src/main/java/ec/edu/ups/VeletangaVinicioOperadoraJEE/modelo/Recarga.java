package ec.edu.ups.VeletangaVinicioOperadoraJEE.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recarga implements Serializable {
	@Id
	@Column(name = "num_recarga")
	private String numero;
	private String cuenta;
	private String celular;
	private Double valor;
	private String estado;
	private static final long serialVersionUID = 1L;

	public Recarga() {

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Recarga [numero=" + numero + ", cuenta=" + cuenta + ", celular=" + celular + ", valor=" + valor + "]";
	}
	
	

}
