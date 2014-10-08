
package br.com.sgce.converter;

import br.com.sgce.entity.Serie;
import br.com.sgce.repository.SerieRepository;
import br.com.sgce.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "serieConverter",forClass = Serie.class)
public class SerieConverter implements Converter{
    
    private SerieRepository serieRepository;

    public SerieConverter() {
        serieRepository = CDIServiceLocator.getBean(SerieRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Serie retorno = null;
        if (value != null) {
            Long id = new Long(value);
            retorno = serieRepository.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Serie serie = (Serie) value;
            return serie.getId() == null ? null : serie.getId().toString();
        }

        return "";

    }
    
}
