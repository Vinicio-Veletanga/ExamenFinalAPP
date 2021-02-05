package ec.edu.ups.VeletangaVinicioCajeraJEE.on;

import javax.ejb.Local;

import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Cliente;
import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Cuenta;

@Local
public interface GestionCajeraLocal {
	public void guardarCliente(Cliente c);
	public void crearCuenta(Cuenta c);
	public Cuenta buscarCuenta(String numero);
	public Cliente buscarCliente(String cedulaCliente);
	public String Recargar(String nuemero,String numeroc,double valor);
}
