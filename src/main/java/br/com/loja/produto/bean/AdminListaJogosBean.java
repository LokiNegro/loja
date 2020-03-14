package br.com.loja.produto.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.loja.produto.daos.JogoDao;
import br.com.loja.produto.models.Jogo;

// Model = @Named e @RequestScoped
@Model
public class AdminListaJogosBean {
	
	@Inject
	private JogoDao dao;
	
	private List<Jogo> jogos = new ArrayList<>();
	
	public List<Jogo> getJogos(){
		this.jogos = dao.listar();
		
		return jogos;
	}
}
