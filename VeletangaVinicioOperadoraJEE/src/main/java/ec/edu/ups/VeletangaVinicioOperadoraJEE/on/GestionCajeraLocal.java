package ec.edu.ups.VeletangaVinicioOperadoraJEE.on;

import javax.ejb.Local;

import ec.edu.ups.VeletangaVinicioOperadoraJEE.*;
import ec.edu.ups.VeletangaVinicioOperadoraJEE.modelo.Recarga; 

@Local
public interface GestionCajeraLocal {
	public Recarga buscarRecarga(String numero); 
	public void aprobar(String numero);
}
