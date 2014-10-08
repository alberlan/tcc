package br.com.sgce.repository;

import br.com.sgce.entity.Funcionario;
import br.com.sgce.entity.TipoFuncionario;
import br.com.sgce.filter.FuncionarioFilter;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class FuncionarioRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Funcionario guardar(Funcionario funcionario) {

        return manager.merge(funcionario);

    }

    public Funcionario porNome(String nome) {
        try {
            return manager.createQuery("from Funcionario where upper(nome) = :nome", Funcionario.class)
                    .setParameter("nome", nome.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /*Metodo para filtrar aluno e mandar pra tela,da Forma com que esta sendo feito posso pesquisar
     por outro atributo basta adicionar na classe Alunofilter*/
    public List<Funcionario> filtrados(FuncionarioFilter filtro) {
        Session session = manager.unwrap(Session.class); //Pedindo pro manager desempacotar a session do hibernate, e joga na variavel session.
        Criteria criteria = session.createCriteria(Funcionario.class); //criando um criterio para entidade Aluno.

        if (StringUtils.isNotBlank(filtro.getNome())) {
            criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("nome")).list();
    }

    public List<Funcionario> buscarProfessor() {
        return manager.createQuery("from Funcionario funcionario"
                + " where funcionario = 'PROFESSOR'").getResultList();
    }

    public List<Funcionario> buscarFuncionario() {
        return manager.createQuery("from Funcionario", Funcionario.class).getResultList();

    }

    //Retorna um aluno dado o id dele
    public Funcionario porId(Long id) {
        return manager.find(Funcionario.class, id);
    }
}
