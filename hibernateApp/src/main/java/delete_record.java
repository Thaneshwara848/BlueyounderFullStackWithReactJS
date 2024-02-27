import entity.emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class delete_record {
    public static void main(String[] args) {
        try{
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            emp e = new emp();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the id");
            int id = sc.nextInt();
            e.setUid(id);

//            em.remove(e);
            em.remove(em.contains(e) ? e : em.merge(e));
            tx.commit();

            System.out.println("Data Deleted....");
        }catch(Exception e){
            System.out.println(e);

        }
    }
}
