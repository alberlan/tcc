
package teste;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.entity.Serie;
import br.com.sgce.repository.DisciplinaRepository;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;


public class teste implements Serializable{
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;
    private DisciplinaRepository disciplinaRepository;
    
/*    public static void main(String[] args){
        Disciplina disciplina = new Disciplina();
// atribuicoes de disciplina
disciplina = manager.merge(disciplina);

Serie s = new Serie();
// atribuicoes da turma

s.getDisciplinas().add(disciplina);

s = manager.merge(s);
    }
    */
}
