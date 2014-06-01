package br.com.sgce.converter;

import br.com.sgce.entity.Cidade;
import br.com.sgce.repository.CidadeRepository;
import br.com.sgce.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {

    // @Inject
    private CidadeRepository cidadeRepository;

    public CidadeConverter() {
        cidadeRepository = CDIServiceLocator.getBean(CidadeRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cidade retorno = null;
        if (value != null) {
            Long id = new Long(value);
            retorno = cidadeRepository.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            return ((Cidade) value).getId().toString();
        }

        return "";

    }
}
