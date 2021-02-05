package ec.edu.ups.VeletangaVinicioCajeraJEE.on;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import ec.edu.ups.VeletangaVinicioCajeraJEE.dao.*;
import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Cliente;
import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Cuenta;
import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Recarga;


@Stateless
public class GestionCajeraON implements GestionCajeraLocal {
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@Inject
	private CuentaDAO cuentaDAO;
	
	@Inject
	private RecargaDAO recargaDAO;
	
	
	public void guardarCliente(Cliente c) {
		clienteDAO.insert(c);
	}
	
	
	public Cliente buscarCliente(String cedulaCliente) {
		Cliente cliente = clienteDAO.read(cedulaCliente);
		return cliente;
	}
	
	public Cuenta buscarCuenta(String numero) {
		Cuenta cuenta = cuentaDAO.read(numero);
		return cuenta;
	}
	
	public void crearCuenta(Cuenta c) {
		Cuenta c1 = cuentaDAO.read(c.getNumeroc());
		if (c1!=null) {
			Cliente cl = c1.getCliente();
			c1.setCliente(cl);
			c1.setMonto(c.getMonto());
			c1.setNumeroc(c.getNumeroc());
			cuentaDAO.insert(c1);
			
		}
		
	}

	
	public String Recargar(String numero,String numeroc,double valor) {
		 Cuenta c = cuentaDAO.read(numeroc);
		 if (c != null) {
			 Recarga rc = new Recarga();
			 rc.setCelular(numero);
			 rc.setCuenta(numeroc);
			 rc.setValor(valor);
		    rc.setNumero("001122");	 
		 }else {
				return "Cuenta no existe";
			}
		return null;
			 			
	}
}
