import entity.emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Update_record {
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

            System.out.println("Enter the salary");
            int sal = sc.nextInt();

            e.setSalary(sal);
            e.setUid(id);


            em.merge(e);
            tx.commit();

            System.out.println("Data inserted....");
        }catch(Exception e){
            System.out.println(e);

        }
    }
}
