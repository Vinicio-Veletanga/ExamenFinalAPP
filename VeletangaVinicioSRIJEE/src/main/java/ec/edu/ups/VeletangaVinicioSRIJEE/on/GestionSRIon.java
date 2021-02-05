package ec.edu.ups.VeletangaVinicioSRIJEE.on;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.VeletangaVinicioSRIJEE.dao.CuentaDAO;
import ec.edu.ups.VeletangaVinicioSRIJEE.dao.FacturaDAO;
import ec.edu.ups.VeletangaVinicioSRIJEE.dao.RecargaDAO;
import ec.edu.ups.VeletangaVinicioSRIJEE.modelo.Cuenta;
import ec.edu.ups.VeletangaVinicioSRIJEE.modelo.Factura;
import ec.edu.ups.VeletangaVinicioSRIJEE.modelo.Recarga;

@Stateless
public class GestionSRIon implements GestionSRILocal {
	@Inject
	private FacturaDAO facturaDAO;
	@Inject
	private CuentaDAO cuentaDAO;
	@Inject
	private RecargaDAO recargaDAO;
	private ArrayList<String> lista;

	public void aprobar(String numero) {
		lista = new ArrayList<String>();
		lista.add("APROBADO");
		lista.add("RECHAZADA");
		List<Recarga> rc = facturaDAO.getRecargas();
		for (Recarga re : rc) {
			if (re.getEstado() == "APROBADO") {
				Random r = new Random();
				int valorDado = r.nextInt(1); // Entre 0 y 1
				String est = lista.get(valorDado);
				Factura fa = new Factura();
				if (est.equalsIgnoreCase("APROBADO")) {
					facturar(re.getCuenta(),re.getValor());
					fa.setEstado(est);
				} else if (est.equalsIgnoreCase("RECHAZADA")) {
					fa.setEstado(est);
					facturaDAO.insert(fa);
				}

			}

		}

	}
	
	public void facturar(String numeroc,double valor) {		
		Cuenta cu = cuentaDAO.read(numeroc);
		 if(cu!=null) {
			 			 Factura fa = new Factura();
			 fa.setCedulaCliente(cu.getCliente().getCedula());
			 fa.setCuenta(cu.getNumeroc());
			 fa.setNumero("0002");
			 			 Recarga rec = recargaDAO.read(cu.getNumeroc());			 
			 fa.setTotal(rec.getValor());
			 facturaDAO.insert(fa);
			double va = cu.getMonto() - valor;
			cu.setMonto(va);
			cuentaDAO.update(cu);
						
		 }
		
			
	}
	
	 

}
