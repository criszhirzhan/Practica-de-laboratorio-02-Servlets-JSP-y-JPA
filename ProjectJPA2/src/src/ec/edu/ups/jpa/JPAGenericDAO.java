package src.ec.edu.ups.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sound.midi.Soundbank;

import src.ec.edu.ups.dao.DAOFactory;
import src.ec.edu.ups.dao.GenericDAO;
import src.ec.edu.ups.entidades.Telefono;
import src.ec.edu.ups.entidades.Usuario;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	private Class<T> persistentClass;
	protected EntityManager em;

	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("ProjectJPA2").createEntityManager();
	}

	@Override
	public void create(T entity) {
		// System.out.println("INGRESANDO: /n");
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("INGRESANDO: /n");
			System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	@Override
	public T read(ID id) {
		System.out.println("Buscando...");
		return em.find(persistentClass, id);
	}

	@Override
	public void update(T entity) {
		System.out.println("Actualizando.....");
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	// entity debe estar en estado de "Managed"
	@Override
	public void delete(T entity) {
		System.out.println("ELIMINANDO...");
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	@Override
	public void deleteByID(ID id) {
		T entity = this.read(id);
		if (entity != null)
			this.delete(entity);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> findAll() {
		em.getTransaction().begin();
		List<T> lista = null;
		try {
			javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(persistentClass));
			lista = em.createQuery(cq).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;

	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscar(String email, String contrasena) {
		Query nativeQuery = em.createNativeQuery("SELECT * FROM usuario WHERE correo = ? AND pwd =? ", Usuario.class);
		nativeQuery.setParameter(1, email);
		nativeQuery.setParameter(2, contrasena);

		return (Usuario) nativeQuery.getSingleResult();
	}

	@Override
	public List<Telefono> buscarCedula(String cedula) {
		System.out.println("Consulta Realizada...");
		Query nativeQuery = em.createNativeQuery(
				"SELECT id, numero, operadora, tipo, usuario_cedula FROM usuario, telefono WHERE telefono.usuario_cedula=usuario.cedula and usuario.cedula= ?",
				Telefono.class);
		nativeQuery.setParameter(1, cedula);
		System.out.println("Consulta Realizada...");
		return (List<Telefono>) nativeQuery.getResultList();
	}

	@Override
	public List<Telefono> buscarCorreo(String correo) {
		Query nativeQuery = em.createNativeQuery(
				"SELECT * FROM usuario, telefono WHERE telefono.usuario_cedula=usuario.cedula and usuario.correo= ?",
				Telefono.class);
		nativeQuery.setParameter(1, correo);
		return (List<Telefono>) nativeQuery.getResultList();

	}

	@Override
	public List<Telefono> buscarCedInv(String cedula) {

		Query nativeQuery = em.createNativeQuery(
				"SELECT * FROM usuario, telefono WHERE telefono.usuario_cedula=usuario.cedula and usuario.cedula= ?",
				Telefono.class);
		nativeQuery.setParameter(1, cedula);
		return (List<Telefono>) nativeQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String[] attributes, String[] values, String order, int index, int size) {
		// Se crea un criterio de consulta
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
		// Se establece la clausula FROM
		Root<T> root = criteriaQuery.from(this.persistentClass);
		// Se establece la clausula SELECT
		criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
		// // Se configuran los predicados,
		// combinados por AND
		Predicate predicate = criteriaBuilder.conjunction();
		for (int i = 0; i < attributes.length; i++) {
			Predicate sig = criteriaBuilder.like(root.get(attributes[i]).as(String.class), values[i]);
			// Predicate sig =
			// criteriaBuilder.like(root.get(attributes[i]).as(String.class),
			// values[i]);
			predicate = criteriaBuilder.and(predicate, sig);
		}
		// Se establece el WHERE
		criteriaQuery.where(predicate);
		// Se establece el orden
		if (order != null)
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get(order))); // Se
		// crea
		// el
		// resultado
		if (index >= 0 && size > 0) {
			TypedQuery<T> tq = em.createQuery(criteriaQuery);
			tq.setFirstResult(index);
			tq.setMaxResults(size); // Se realiza la query
			return tq.getResultList();
		} else {
			// Se realiza la query
			Query query = em.createQuery(criteriaQuery);
			return query.getResultList();
		}

	}

	
	//Metodo aplicar para encontrar un objeto en especifico. Ejemplo: un usuario por el correo electronico y contraseña.
	@Override
	public T buscar(String[] attributes, String values[]) {
		// TODO Auto-generated method stub
		// Se crea un criterio de consulta
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
		// Se establece la clausula FROM
		Root<T> root = criteriaQuery.from(this.persistentClass);
		// Se establece la clausula SELECT
		criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
		// // Se configuran los predicados,
		// combinados por AND
		Predicate predicate = criteriaBuilder.conjunction();
		for (int i = 0; i < attributes.length; i++) {
			Predicate sig = criteriaBuilder.like(root.get(attributes[i]).as(String.class), values[i]);
			// Predicate sig =
			// criteriaBuilder.like(root.get(attributes[i]).as(String.class),
			// values[i]);
			predicate = criteriaBuilder.and(predicate, sig);
		}
		// Predicate sig =
		// criteriaBuilder.like(root.get(attributes[i]).as(String.class),
		// values[i]);
		
		criteriaQuery.where(predicate);

		Query query = em.createQuery(criteriaQuery);
		return (T) query.getSingleResult();
	}

}