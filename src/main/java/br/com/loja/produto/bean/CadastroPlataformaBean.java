package br.com.loja.produto.bean;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.loja.produto.daos.PlataformaDao;
import br.com.loja.produto.models.Plataforma;

@ManagedBean
@Model
public class CadastroPlataformaBean {

	private Plataforma plataforma = new Plataforma();

	
	@Inject
	private PlataformaDao dao;
	@Inject
	private FacesContext context;
	
	@Transactional
	public String salvar() {
		dao.salvar(plataforma);

		
		//(context= FacesContext.gtCurrentInstance())		
		context.getExternalContext()
			.getFlash().setKeepMessages(true);
		context
			.addMessage(null, new FacesMessage("Plataforma cadastrado com sucesso!"));
		
		return "/jogos/plataformas?faces-redirect=true";
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	
	
}
