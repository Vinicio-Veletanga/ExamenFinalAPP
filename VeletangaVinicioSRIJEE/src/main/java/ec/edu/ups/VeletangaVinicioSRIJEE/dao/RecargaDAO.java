package ec.edu.ups.VeletangaVinicioSRIJEE.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.VeletangaVinicioSRIJEE.modelo.Recarga;



@Stateless
public class RecargaDAO {
	@PersistenceContext(name = "VeletangaVinicioSRIJEEPersistenceUnit") 
	private EntityManager em;
	
	public void insert( Recarga c) {
		em.persist(c);
	}
	
	public void update( Recarga c) {
		em.merge(c);
	} 
	public  Recarga read(String cedulaCliente) {
		return em.find(Recarga.class, cedulaCliente);
	} 
	public void delete(String cedulaCliente) {
		 Recarga c = read(cedulaCliente);
		em.remove(c);
	}
	public List<Recarga> getClientes() {
		String jpql = "SELECT c FROM  Recarga ";

		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	} 
}
