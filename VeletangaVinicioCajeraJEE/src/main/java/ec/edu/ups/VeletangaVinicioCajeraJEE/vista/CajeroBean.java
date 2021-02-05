/**
 * 
 */
package ec.edu.ups.VeletangaVinicioCajeraJEE.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import ec.edu.ups.VeletangaVinicioCajeraJEE.dao.*;
import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Cliente;
import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Cuenta;
import ec.edu.ups.VeletangaVinicioCajeraJEE.on.GestionCajeraLocal;



/**
 * @author Gabriel Leonardo Chu
 *
 */

@ManagedBean
@ViewScoped
public class CajeroBean {
	@Inject
	private GestionCajeraLocal clienteON;

	private Double monto;

	private Cliente cliente;

	private Cuenta cuenta;
	private boolean editable;
	private String numero;
	
	
	
	private PieChartModel pieModel;
	
	private boolean grafica;

	@PostConstruct
	public void init() {
		cuenta = new Cuenta();
		cliente = new Cliente();
		grafica = false;
	}

	
 public Double buscarC() {
	  Cuenta cu = clienteON.buscarCuenta(numero);
	  return cu.getMonto();
 }
 public String buscarCliente(String cedula) {
	  Cliente cl = clienteON.buscarCliente(cedula);
	  return cl.getNombre();
}
	/**
	 * Metodo para obtener un Monto
	 * 
	 * @return Me devuelve un valor de una transaccion
	 */
	public Double getMonto() {
		return monto;
	}

	/**
	 * Metodo para asignar un valor al monto
	 * 
	 * @param monto El parametro moto me permite asignar un valor al monto
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}

	/**
	 * Metodo para obtener un Cliente
	 * 
	 * @return Un cliente para se utilizado en la paguina
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Metodo para asignar un cliente
	 * 
	 * @param cliente el parametro cliente me permite asignar un valor a mi variable
	 *                cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	/**
	 * Metodo para asignar valores a la lista
	 * 
	 * @param listaTra el parametro listaTra me permite asignar una lista de
	 *                 transacciones a mi variable local de Tipo Lista de
	 *                 Transacciones
	 */
	

	/**
	 * Metodo para asignar un valor booleano
	 * 
	 * @return Si es TRUE o FALSE
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Metodo para asignar un valor booleano
	 * 
	 * @param editable El parametro editable me permite cambiar a TRUE o FALSE el
	 *                 booleano
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	
	

	/**
	 * Metodo para obtener la grafica Pie
	 * @return Una grafica que representa los tipos de clientes
	 */
	public PieChartModel getPieModel() {
		return pieModel;
	}
	
	/**
	 * Asigna los valores al Pie
	 * @param pieModel El parametro pieModel me permite
	 * asignar valores para crear la grafica tipo Pie
	 */
	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	/**
	 * Metodo para obtener valor de mostrar la grafica
	 * @return El valore de TRUE o FALSE 
	 */
	public boolean isGrafica() {
		return grafica;
	}
	
	/**
	 * Metodo para asignar el valor a la variable grafica
	 * @param grafica El parmtro grafica me permite asignar
	 * true o false para mostrar la grafixa
	 */
	public void setGrafica(boolean grafica) {
		this.grafica = grafica;
	}

	/**
	 * Metodo para validar la cedula de Un Cliente
	 * 
	 * @return Me devuelve un Mensaje si la ceudla es correcta, incorreta o si el
	 *         cliente no esta registrado
	 */

	
	 public String crearcuenta(){
	       
		 	Cuenta ca = clienteON.buscarCuenta(cuenta.getNumeroc());
		 	ca.setMonto(monto);
		 	ca.setCliente(cliente);
		 	try {
		 		clienteON.crearCuenta(ca);
		 		addMessage("Confirmacion", "CUENTA CREADA");
			} catch (Exception e1) {
				// TODO: handle exception
				e1.getMessage();
			}
		 	
		 	return "IndexCajera";
	 }
	 
	  public void addMessage(String summary, String detail) {   
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.getExternalContext().getFlash().setKeepMessages(true);
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	    }
	 
	 public void handleClose(CloseEvent event) {
	        addMessage(event.getComponent().getId() + " closed", "So you don't like nature?");
	    }
	     
	    public void handleMove(MoveEvent event) {
	        event.setTop(500);
	    	addMessage(event.getComponent().getId() + " moved", "Left: " + event.getLeft() + ", Top: " + event.getTop());
	    }

	    

}
