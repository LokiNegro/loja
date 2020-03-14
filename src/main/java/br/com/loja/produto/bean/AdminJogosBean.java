package br.com.loja.produto.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.loja.produto.daos.JogoDao;
import br.com.loja.produto.daos.PlataformaDao;
import br.com.loja.produto.infra.FileSaver;
import br.com.loja.produto.models.Jogo;
import br.com.loja.produto.models.Plataforma;

//CDI
@ManagedBean
@Model
public class AdminJogosBean {

	private Jogo jogo = new Jogo();

	
	@Inject
	private JogoDao dao;
	@Inject
	private PlataformaDao plataformaDao;
	@Inject
	private FacesContext context;
	
	private Part capaJogo;
	

	
	@PostConstruct
	public void inicializar() {
	}
	
	@Transactional
	public String salvar() {
		FileSaver fileSaver = new FileSaver();
		String capaPath = fileSaver.write(capaJogo, "jogos");
		jogo.setCapaPath(capaPath);
		dao.salvar(jogo);

		
		//(context= FacesContext.gtCurrentInstance())		
		context.getExternalContext()
			.getFlash().setKeepMessages(true);
		context
			.addMessage(null, new FacesMessage("Jogo cadastrado com sucesso!"));
		
		return "/jogos/lista?faces-redirect=true";
	}

	
	public List<Plataforma> getPlataformas() {
		return plataformaDao.listar();
	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Part getCapaJogo() {
		return capaJogo;
	}

	public void setCapaJogo(Part capaJogo) {
		this.capaJogo = capaJogo;
	}

}
