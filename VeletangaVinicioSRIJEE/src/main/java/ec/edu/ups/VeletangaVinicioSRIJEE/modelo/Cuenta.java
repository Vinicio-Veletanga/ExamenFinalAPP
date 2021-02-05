package ec.edu.ups.VeletangaVinicioSRIJEE.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Cuenta implements Serializable {

	@Id
	@Column(name = "numero_cuenta")
	private String numeroc;
	private static final long serialVersionUID = 1L;
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "cedula")
	private Cliente cliente;
	private Double monto;
	public String getNumeroc() {
		return numeroc;
	}
	public void setNumeroc(String numeroc) {
		this.numeroc = numeroc;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "Cuenta [numeroc=" + numeroc + ", cliente=" + cliente + ", monto=" + monto + "]";
	}
	
	

}
