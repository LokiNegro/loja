package br.com.loja.produto.models;

public enum Sexo {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	 String descricao;

    Sexo(String descricao) {
         this.descricao = descricao;
    }

    public String getDescricao() {
         return this.descricao;
   }
    
    public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}