package br.com.loja.produto.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.loja.produto.daos.JogoDao;
import br.com.loja.produto.models.Jogo;

@Model
public class PrincipalBean {
	

	private Jogo jogo;
	
	
	@Inject
	private JogoDao dao;

	


	public List<Jogo> ultimosLancamentos(){
		return dao.ultimosLancamentos();
	}
	
	public List<Jogo> demaisJogos(){
		return dao.demaisJogos();
	}
	
	public List<Jogo> xboxJogos(String nome){
		return dao.pesquisaPlataformaJogos("Xbox One");
	}
	public List<Jogo> playstationJogos(String nome){
		return dao.pesquisaPlataformaJogos("Playstation 4");
	}
	
	public List<Jogo> pcJogos(String nome){
		return dao.pesquisaPlataformaJogos("PC");
	}
	
	public List<Jogo> nintendoJogos(String nome){
		return dao.pesquisaPlataformaJogos("Nintendo Switch");
	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	
	
}
