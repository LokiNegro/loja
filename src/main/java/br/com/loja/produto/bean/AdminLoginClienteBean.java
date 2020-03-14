package br.com.loja.produto.bean;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.loja.produto.daos.ClienteDao;
import br.com.loja.produto.models.Cliente;;

@ManagedBean
@Model
public class AdminLoginClienteBean{

	private Cliente cliente = new Cliente();

	@Inject
	private ClienteDao dao;
	@Inject
	private FacesContext context;
	
	@Transactional
	public String logar(){
	     if(dao.buscarLogin(cliente.getUsuario(), cliente.getSenha()) != null ){
	          return "/Principal?faces-redirect=true";
	     }
	     
	     FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
	     context.addMessage(null, msg);
	     return "";              
	     }
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
