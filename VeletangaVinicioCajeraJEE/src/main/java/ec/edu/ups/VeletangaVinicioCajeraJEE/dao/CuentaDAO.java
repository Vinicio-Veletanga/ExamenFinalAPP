package ec.edu.ups.VeletangaVinicioCajeraJEE.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ec.edu.ups.VeletangaVinicioCajeraJEE.modelo.Cuenta;

@Stateless
public class CuentaDAO {
	@PersistenceContext(name = "VeletangaVinicioCajeraJEEPersistenceUnit")
	private EntityManager em;

	public void insert(Cuenta c) {
		em.persist(c);
	}

	public void update(Cuenta c) {
		em.merge(c);
	}

	public Cuenta read(String numero) {
		return em.find(Cuenta.class, numero);
	}

	public void delete(String numero) {
		Cuenta c = read(numero);
		em.remove(c);
	}

	public List<Cuenta> getCuentas() {
		String jpql = "SELECT c FROM Cuenta";

		Query q = em.createQuery(jpql, Cuenta.class);
		return q.getResultList();
	}
}
