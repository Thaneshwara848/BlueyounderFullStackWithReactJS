import entity.emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Insert_record {
    public static void main(String[] args) {
        try{
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            emp e = new emp();
            e.setAge(12);
            e.setUid(24);
            e.setDesig("dev");
            e.setName("ra");
            e.setSalary(22000);

            em.persist(e);
            tx.commit();

            System.out.println("Data inserted....");
        }catch(Exception e){
            System.out.println(e);

        }
    }
}
