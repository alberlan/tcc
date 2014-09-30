
package br.com.sgce.converter;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.repository.DisciplinaRepository;
import br.com.sgce.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



@FacesConverter(value = "disciplinaConverter" , forClass = Disciplina.class)
public class DisciplinaConverter implements Converter{
    
    private DisciplinaRepository disciplinaRepository;

    public DisciplinaConverter() {
        disciplinaRepository = CDIServiceLocator.getBean(DisciplinaRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Disciplina retorno = null;
        if (value != null) {
            Long id = new Long(value);
            retorno = disciplinaRepository.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Disciplina disciplina = (Disciplina) value;
            return disciplina.getId() == null ? null : disciplina.getId().toString();
        }

        return "";

    }
    
    
}
