package br.com.loja.produto.daos;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.loja.produto.models.Cliente;

@Stateful
public class ClienteDao {
	
	@PersistenceContext(unitName="loja-dev")
	private EntityManager manager;
	
	public ClienteDao dao;
	
	public Cliente buscarLogin(String usuario, String senha){
		try{
			 return  (Cliente) manager.
					 createQuery("select c from Cliente c where c.usuario = :usuario and c.senha = :senha").
					 setParameter("usuario", usuario).setParameter("senha", senha).getSingleResult();							
			}catch (NoResultException nre){
			return null;
			}
	}
		
	public void salvar(Cliente cliente) {
		manager.persist(cliente);
	}
	
	public List<Cliente> listar() {
		String jpql = "select c from Cliente c";
		return manager.createQuery(jpql, Cliente.class).getResultList();
	}

	public Cliente buscarPorId(Integer id) {
		String jpql = "select c from Cliente c where c.id = :id";
		return manager.createQuery(jpql, Cliente.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
}
