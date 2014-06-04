package br.com.sgce.converter;

import br.com.sgce.entity.Funcionario;
import br.com.sgce.repository.FuncionarioRepository;
import br.com.sgce.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioConverter() {
        funcionarioRepository = CDIServiceLocator.getBean(FuncionarioRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Funcionario retorno = null;
        if (value != null) {
            Long id = new Long(value);
            retorno = funcionarioRepository.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Funcionario funcionario = (Funcionario) value;
            return funcionario.getId() == null ? null : funcionario.getId().toString();
        }

        return "";

    }
}
