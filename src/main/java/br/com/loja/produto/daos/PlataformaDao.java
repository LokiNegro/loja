package br.com.loja.produto.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.loja.produto.models.Plataforma;

public class PlataformaDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Plataforma> listar() {
		return manager.createQuery(
				"select p from Plataforma p", Plataforma.class)
				.getResultList();
	}

	public void salvar(Plataforma plataforma) {
		manager.persist(plataforma);	
	}
	
}






