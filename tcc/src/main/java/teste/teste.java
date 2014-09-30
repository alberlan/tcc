package teste;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.entity.Serie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class teste {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SgcePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction trx = manager.getTransaction();
        trx.begin();

        // atribuicoes de disciplina
        Disciplina disciplina = new Disciplina();
        disciplina.setId(Long.MIN_VALUE);
        disciplina.setDescricao("ops");
        disciplina = manager.merge(disciplina);
        // atribuicoes de serie
        Serie serie = new Serie();
        serie.setId(Long.MIN_VALUE);
        serie.setDescricao("10 SERIE");
        serie.setTurno("t");
        serie.getDisciplinas().add(disciplina);

        serie = manager.merge(serie);

        trx.commit();

        manager.close();

    }
}
