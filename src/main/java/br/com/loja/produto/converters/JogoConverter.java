package br.com.loja.produto.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.loja.produto.models.Jogo;

@FacesConverter("jogoConverter")
public class JogoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String id) {
		if (id == null || id.trim().isEmpty()) return null;
		System.out.println("Convertendo para Objeto: " + id);
		
		Jogo jogo = new Jogo();
		jogo.setId(Integer.valueOf(id));
		
		return jogo;
	}

	@Override
	public String getAsString(FacesContext context, 
			UIComponent component, Object jogoObject) {
		if (jogoObject == null) return null;
		System.out.println("Convertendo para String: " + jogoObject);
		
		Jogo jogo = (Jogo) jogoObject;
		return jogo.getId().toString();
	}

}





