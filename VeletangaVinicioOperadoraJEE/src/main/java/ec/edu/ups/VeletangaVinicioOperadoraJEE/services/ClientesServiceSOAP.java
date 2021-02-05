package ec.edu.ups.VeletangaVinicioOperadoraJEE.services;
  

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.VeletangaVinicioOperadoraJEE.on.GestionCajeraLocal;

@WebService
public class ClientesServiceSOAP {

	@Inject
	private GestionCajeraLocal on;

	 

	@WebMethod
	public String aprobarRecarga(String cuenta) {
		try {
			on.aprobar(cuenta);
			return "Ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}

	}
	
	
}
