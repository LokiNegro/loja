package br.com.loja.produto.bean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.loja.produto.models.Sexo;
import br.com.loja.produto.daos.ClienteDao;
import br.com.loja.produto.models.Cliente;
import br.com.loja.produto.models.Estado;;

@ManagedBean
@Model
public class AdminClienteBean{

	private Cliente cliente = new Cliente();

	private List<Sexo> sexos;
	
	private List<Estado> estados;

	@Inject
	private ClienteDao dao;
	@Inject
	private FacesContext context;

	@PostConstruct
	public void inicializar() {
		this.sexos = Arrays.asList(Sexo.values());
		this.estados = Arrays.asList(Estado.values());
	}
	
	@Transactional
	public String salvar() {
		dao.salvar(cliente);
		
		context.getExternalContext()
			.getFlash().setKeepMessages(true);
		
		context
			.addMessage(null, new FacesMessage("Cliente cadastrado com sucesso!"));
		
		return "/Home?faces-redirect=true";
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List getSexos() {
		return sexos;
	}

	public List<Estado> getEstados() {
		return estados;
	}
	
}
