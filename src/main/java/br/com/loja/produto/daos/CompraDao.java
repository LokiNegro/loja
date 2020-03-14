package br.com.loja.produto.daos;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.loja.produto.models.Cliente;
import br.com.loja.produto.models.Compra;
import br.com.loja.produto.models.Jogo;


public class CompraDao {
	@PersistenceContext(unitName="loja-dev")
	private EntityManager manager;
	
	public void salvar(Compra compra) {
		manager.merge(compra);
	}

	
	
}

