package br.com.loja.produto.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Jogo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String titulo;
	
	@Lob
	@Length(min=10)
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String desenvolvedor;
	
	@DecimalMin("2")
	private BigDecimal preco;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataPublicacao;
	
	private String capaPath;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Size(min=1)
	@NotNull
	private List<Plataforma> plataformas = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getDesenvolvedor() {
		return desenvolvedor;
	}


	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	@Override
	public String toString() {
		return "Jogo [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", desenvolvedor=" + desenvolvedor
				+ ", preco=" + preco + ", plataformas=" + plataformas + "]";
	}


	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}


	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}


	public String getCapaPath() {
		return capaPath;
	}


	public void setCapaPath(String capaPath) {
		this.capaPath = capaPath;
	}


	public List<Plataforma> getPlataformas() {
		return plataformas;
	}


	public void setPlataformas(List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}



	
	
	
	
}
