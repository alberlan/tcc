


import br.com.sgce.entity.Disciplina;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Teste {
    
    
    public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SgcePU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();
                
                Disciplina disciplina = new Disciplina();
                disciplina.setDescricao("testando");            
                	               
		
		manager.persist(disciplina);

		trx.commit();
	}
    
}
    

