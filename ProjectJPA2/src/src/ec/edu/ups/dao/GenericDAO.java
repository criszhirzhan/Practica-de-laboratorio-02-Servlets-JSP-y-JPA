package src.ec.edu.ups.dao;
import java.util.List;


import src.ec.edu.ups.entidades.Telefono;
import src.ec.edu.ups.entidades.Usuario;



public interface GenericDAO<T ,ID> {
	
	public void createTable();

	public void create(T entity);

	public T read(ID id);

	public void update(T entity);

	public void delete(T entity);

	public List<T> find();

	Usuario buscar(String email, String contrasena);
	public List<Telefono> buscarCedula(String cedula);

	public List<Telefono> buscarCorreo(String correo);

	public List<Telefono> buscarCedInv(String cedula);


	void deleteByID(ID id);

	List<T> findAll();

	List<T> find(String[] attributes, String[] values, String order, int index, int size);

	public T buscar(String[] attributes, String[] values);


}
