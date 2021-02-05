package ec.edu.ups.VeletangaVinicioCajeraJEE.vista;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.servlet.http.Part;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.MoveEvent;
import org.primefaces.model.file.UploadedFile;

import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Cliente;
import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Cuenta;
import ec.edu.ups.VeletangaVinicioCajeraJEE.on.GestionCajeraLocal;

/**
 * @author ADMINX
 *
 */
@ManagedBean
@SessionScoped
public class ClientesBean {
	// Atributos de la clase
	@Inject
	private GestionCajeraLocal gestionUsuarios;
	private Cliente cliente;
	private String numeroCuenta;
	private String cedulaParametro;
	private Cuenta cuenta;
	
	
	

	/**
	 * Metodo que permite inicializar atributos y metodos al momento que se llama a
	 * esta clase
	 */
	@PostConstruct
	private void iniciar() { 
		cuenta = new Cuenta();
		cliente = new Cliente();  
	}

	/**
	 * Metodo que permite obtener el atributo cliente
	 * 
	 * @return Atributo cliente de la clase
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Metodo que permite asignar un valor al atributo cliente
	 * 
	 * @param cliente Variable asiganda al atributo cliente de la clase
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * Metodo que permite asignar un valor al atributo numeroCuenta de la clase
	 * 
	 * @param numeroCuenta Variable asiganda al atributo numeroCuenta de la clase
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * Metodo que permite obtener el atributo cedulaParametro de la clase
	 * 
	 * @return Atributo cedulaParametro de la clase
	 */
	public String getCedulaParametro() {
		return cedulaParametro;
	}
	
	


//	/***
//	 * Metodo que permite obtener el atributo transaccion de la clase
//	 * 
//	 * @return Atributo transaccion de la clase
//	 */
//	public Transaccion getTransaccion() {
//		return transaccion;
//	}

	/**
	 * Metodo que permite asignar un valor al atributo transaccion de la clase
	 * 
	 * @param transaccion Variable asignada al atributo transaccion de la clase
	 */
//	public void setTransaccion(Transaccion transaccion) {
//		this.transaccion = transaccion;
//	}

	

	
	/** 
	 *  Metodo que permite obtener el atributo de tipo lista lstTransacciones de
	 * la clase
	 * @return Atributo de tipo lista lstTransacciones de la clase
	 */
//	public List<Transaccion> getLstTransacciones() {
//		return lstTransacciones;
//	}
//	/** 
//	 * Metodo que permite asignar un valor al atributo de tipo lista lstTransacciones de la clase
//	 * @param lstTransacciones  Variable asignada al atributo de tipo lista
//	 *                           lstTransacciones de la clase
//	 */
//	public void setLstTransacciones(List<Transaccion> lstTransacciones) {
//		this.lstTransacciones = lstTransacciones;
//	}
	
	 
	/**
	 * Metodo que permite crear un cliente
	 * 
	 * @return Nulo
	 */
	public String crearCliente() {
		try {
			gestionUsuarios.guardarCliente(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/** 
	 * Metodo que permite obtener el atributo de tipo double ingresos de la clase
	 * @return Atributo de tipo double ingresos de la clase
	 */
	
	
	/**
	 * Metodo que permite generar el numero de cuenta
	 * 
	 * @return Numero de cuenta que se ha generado
	 */
	public String generarNumeroCuenta() {
		//this.numeroCuenta = gestionUsuarios.generarNumeroDeCuenta();
		return numeroCuenta;
	}
	/** 
	 * Metodo que permite obtener el atributo de tipo String saldoCuenta de la clase
	 * @return Atributo de tipo String saldoCuenta de la clase
	 */
	
	/** 
	 * Metodo que permite asignar un valor al atributo de tipo String saldoCuenta de la clase
	 * @param saldoCuenta Variable asignada al atributo de tipo string saldoCuenta de la clase
	 */
	

	public void handleClose(CloseEvent event) {
		addMessage(event.getComponent().getId() + " closed", "So you don't like nature?");
	}

	public void handleMove(MoveEvent event) {
		event.setTop(500);
		addMessage(event.getComponent().getId() + " moved", "Left: " + event.getLeft() + ", Top: " + event.getTop());
	}
	/** 
	 * Metodo que permite asignar un valor para poder enviar un mensaje de confirmacion 
	 * @param summary Variable tipo String la cual sera el titulo de la confirmacion
	 * @param detail Varibale tipo String en donde se almacenara la descripcion del mensaje
	 */
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Metodo que me permite obtener una lista de los clientes y asignarlo a la
	 * variable lstClientes de la clase
	 */
	

	/**
	 * Metodo que permite cambiar el formato a una fecha
	 * 
	 * @param fecha Fecha a la que se cambia el formato
	 * @return Fecha cambiada el formato
	 */
	public String obtenerFecha(Date fecha) {
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return hourdateFormat.format(fecha);
	}

	
	 
	
	/** 
	 * Metodo que permite guardar una solicitud de credito con sus respectivos atributos
	 * @return Pagina en donde se realiza la Solicitud de Credito
	 * @throws IOException
	 */
//	public String crearSolicitudCredito() throws IOException {
//		System.out.println("ENTRO EN LA SOLICITUD");
//		solicitudDeCredito.setClienteCredito(gestionUsuarios.buscarCliente(cedulaParametro));
//		solicitudDeCredito.setEstadoCredito("Solicitando");
//		solicitudDeCredito.setArCedula(gestionUsuarios.toByteArray(arCedula));
//		solicitudDeCredito.setArPlanillaServicios(gestionUsuarios.toByteArray(arPlanillaServicios));
//		solicitudDeCredito.setArRolDePagos(gestionUsuarios.toByteArray(arRolDePagos));
//		solicitudDeCredito.setGaranteCredito(garante);
//		solicitudDeCredito.setTasaPago(((ingresos - egresos) * 100) / ingresos);
//		if(gestionUsuarios.verificarSolicitudSolicitando(cedulaParametro)) { 
//			gestionUsuarios.guardarSolicitudCredito(solicitudDeCredito);
//			addMessage("Confirmacion", "Solicitud Guardada");
//		}else { 
//			addMessage("Atencion", "Usted ya ha enviado una solicitud de credito para su aprovacion");
//		}
//		garante = new Cliente();
//		solicitudDeCredito = new SolicitudDeCredito();
//		return "SolicitudCredito";
//	}
//	/** 
//	 * Metodo que permite buscar un cliente, en donde se realiza la validacion de que  
//	 * la persona que esta realizando la solicitud de credito no puede ser garante de si misma
//	 */
//	public void buscarGarante() {
//		if (cedulaGarante.equalsIgnoreCase(cedulaParametro)) {
//			mensajeGarante = "No puede ingresar su propia cedula";
//			garante = new Cliente();
//		} else {
//			garante = gestionUsuarios.buscarCliente(cedulaGarante);
//			mensajeGarante = null;
//		}
//	}
	/** 
	 * Metodo que me permite validar que los egresos sean mayores a los ingresos
	 * @param ingresos Variable tipo double en donde se asigna los ingresos del cliente
	 * @param egresos Variable tipo double en donde se asigna los egresos del cliente
	 * @return Variable tipo string en donde me devuelve un mensaje si los egresos son mayores a los ingresos
	 */
	public String confirmarTasaPago(double ingresos, double egresos) {
		if (egresos > ingresos) {
			return "Los egresos no debe ser mayor a los ingresos";
		}
		return null;
	} 
}