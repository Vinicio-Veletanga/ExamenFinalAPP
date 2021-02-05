package ec.edu.ups.VeletangaVinicioSRIJEE.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.VeletangaVinicioSRIJEE.modelo.*;


@Stateless
public class FacturaDAO {
	@PersistenceContext(name = "VeletangaVinicioSRIJEEPersistenceUnit") 
	private EntityManager em;
	
	public void insert(Factura c) {
		em.persist(c);
	}
	
	public void update( Factura c) {
		em.merge(c);
	} 
	public  Factura read(String cedulaCliente) {
		return em.find(Factura.class, cedulaCliente);
	} 
	public void delete(String cedulaCliente) {
		Factura c = read(cedulaCliente);
		em.remove(c);
	}
	
	public List<Recarga> getRecargas() {
		String jpql = "SELECT c FROM Recarga  ";

		Query q = em.createQuery(jpql, Factura.class);
		return q.getResultList();
	} 
	
	public List<Factura> getFacturas() {
		String jpql = "SELECT c FROM Factura ";

		Query q = em.createQuery(jpql, Factura.class);
		return q.getResultList();
	} 
}
