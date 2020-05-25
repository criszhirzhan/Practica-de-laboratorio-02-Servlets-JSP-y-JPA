package src.ec.edu.ups.dao;
import java.util.List;

import src.ec.edu.ups.entidades.Contacto;
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


	List<Contacto> buscarCorreo(String correo);

	void deleteByID(ID id);

	List<T> findAll();

}
