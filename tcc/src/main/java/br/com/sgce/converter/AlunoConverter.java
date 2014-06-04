
package br.com.sgce.converter;

import br.com.sgce.entity.Aluno;
import br.com.sgce.repository.AlunoRepository;
import br.com.sgce.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Aluno.class)
public class AlunoConverter implements Converter{    
    
    private AlunoRepository alunoRepository;

    public AlunoConverter() {
        alunoRepository = CDIServiceLocator.getBean(AlunoRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Aluno retorno = null;
        if (value != null) {
            Long id = new Long(value);
            retorno = alunoRepository.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Aluno aluno = (Aluno) value;
            return aluno.getId() == null ? null : aluno.getId().toString();
        }

        return "";

    }
    
}
