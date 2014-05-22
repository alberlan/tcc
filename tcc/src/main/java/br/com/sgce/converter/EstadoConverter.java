package br.com.sgce.converter;

import br.com.sgce.entity.Estado;
import br.com.sgce.repository.EstadoRepository;
import br.com.sgce.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

    private EstadoRepository estadoRepository;
    public EstadoConverter(){
        estadoRepository = CDIServiceLocator.getBean(EstadoRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Estado retorno = null;

        if (value != null) {
            Long id = new Long(value);
            retorno = estadoRepository.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            return ((Estado) value).getId().toString();
        }

        return "";

    }
}
