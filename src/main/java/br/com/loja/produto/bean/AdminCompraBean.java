package br.com.loja.produto.bean;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.loja.produto.daos.ClienteDao;
import br.com.loja.produto.daos.CompraDao;
import br.com.loja.produto.daos.JogoDao;
import br.com.loja.produto.models.Cliente;
import br.com.loja.produto.models.Compra;
import br.com.loja.produto.models.Jogo;

@ManagedBean
@ViewScoped
@Model
public class AdminCompraBean {

	private Compra compra = new Compra();
	
	private Jogo jogo = new Jogo();
	
	private Cliente cliente = new Cliente();
	
	private Integer id;
	
	@Inject
	private ClienteDao clienteDao;

	@Inject
	private JogoDao jogoDao;
	
	@Inject
	private CompraDao compraDao;
	
	@Inject
	private FacesContext context;
	
	
	@Transactional
	public String comprar(){
	     if(clienteDao.buscarLogin(cliente.getUsuario(), cliente.getSenha()) != null ){
	    	 this.jogo = jogoDao.buscarPorId(id);
	    	 this.compraDao.salvar(compra);
	    	 System.out.println("Cliente Salvo " + compra + cliente + jogo);
	    		context.getExternalContext()
					.getFlash().setKeepMessages(true);
	    		context
					.addMessage(null, new FacesMessage("Compra feita com sucesso!"));
	    		  return "";
	        //  return "/Principal?faces-redirect=true";   
	     }
	     
	     FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
	     context.addMessage(null, msg);
	     return "";              
	     }
	
	public void carregaDetalhe() {
		this.jogo = jogoDao.buscarPorId(id);
	}

	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	public Jogo getJogo() {
		return jogo;
	}


	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
