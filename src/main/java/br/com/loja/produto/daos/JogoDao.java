package br.com.loja.produto.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateful;

import br.com.loja.produto.models.Jogo;

@Stateful
public class JogoDao {
	
	@PersistenceContext(unitName="loja-dev")
	private EntityManager manager;
	
	public void salvar(Jogo jogo) {
		manager.persist(jogo);
	}

	public List<Jogo> listar() {
		String jpql = "select distinct(j) from Jogo j "
				+ " join fetch j.plataformas";
		return manager.createQuery(jpql, Jogo.class).getResultList();
	}
	
	public Jogo buscarPorId(Integer id) {
//		return manager.find(Jogo.class, id);
		String jpql = "select j from Jogo j JOIN j.plataformas jp where j.id = :id";
		return manager.createQuery(jpql, Jogo.class)
				.setParameter("id", id)
				.getSingleResult();
}

	
	public List<Jogo> ultimosLancamentos() {
		String jpql = "select j from Jogo j order by j.id desc";		
		return manager.createQuery(jpql, Jogo.class).setMaxResults(5).getResultList();
	}

	public List<Jogo> demaisJogos() {
		String jpql = "select j from Jogo j order by j.id desc";		
		return manager.createQuery(jpql, Jogo.class).setFirstResult(5).getResultList();
	}
	
	public List<Jogo> pesquisaPlataformaJogos(String nome){
		String jpql = "select j from Jogo j JOIN j.plataformas jp where jp.nome = :nome order by j.id desc";		
		return manager.createQuery(jpql, Jogo.class).setParameter("nome", nome).setFirstResult(0).getResultList();
	}
	
}


