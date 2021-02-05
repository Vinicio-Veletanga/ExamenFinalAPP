package ec.edu.ups.VeletangaVinicioOperadoraJEE.on;

import java.util.ArrayList;
import java.util.Random;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
 
import ec.edu.ups.VeletangaVinicioOperadoraJEE.dao.RecargaDAO;
import ec.edu.ups.VeletangaVinicioOperadoraJEE.modelo.Recarga;


@Stateless
public class GestionCajeraON implements GestionCajeraLocal {
	
	 
	@Inject
	private RecargaDAO recargaDAO;
	private ArrayList<String> lista;
	  

	public Recarga buscarCuenta(String numero) {
		 Recarga  cuenta = recargaDAO.read(numero);
		return cuenta;
	}

	public void  aprobar(String numero) {
		lista = new ArrayList<String>();
		lista.add("APROBADO");
		lista.add("RECHAZADA");
		Recarga rc = buscarRecarga(numero);		
		Random r = new Random();
		int valorDado = r.nextInt(1);  // Entre 0 y 1
		String est = lista.get(valorDado);
		rc.setEstado(est);
		recargaDAO.update(rc);
				
	}
	

	@Override
	public Recarga buscarRecarga(String numero) {
		Recarga cr = recargaDAO.read(numero);
		// TODO Auto-generated method stub
		return cr;
	}

	 
}
