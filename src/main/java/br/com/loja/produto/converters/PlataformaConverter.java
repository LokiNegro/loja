package br.com.loja.produto.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.loja.produto.models.Plataforma;

@FacesConverter("plataformaConverter")
public class PlataformaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String id) {
		if (id == null || id.trim().isEmpty()) return null;
		System.out.println("Convertendo para Objeto: " + id);
		
		Plataforma plataforma = new Plataforma();
		plataforma.setId(Integer.valueOf(id));
		
		return plataforma;
	}

	@Override
	public String getAsString(FacesContext context, 
			UIComponent component, Object plataformaObject) {
		if (plataformaObject == null) return null;
		System.out.println("Convertendo para String: " + plataformaObject);
		
		Plataforma plataforma = (Plataforma) plataformaObject;
		return plataforma.getId().toString();
	}

}





