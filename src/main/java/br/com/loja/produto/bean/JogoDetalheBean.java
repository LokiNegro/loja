package br.com.loja.produto.bean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.loja.produto.daos.JogoDao;
import br.com.loja.produto.models.Jogo;

@Model
public class JogoDetalheBean {
	
	@Inject
	private JogoDao dao;
	
	private Jogo jogo;
	
	private Integer id;
	
	public void carregaDetalhe() {
		this.jogo = dao.buscarPorId(id);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
	
}
