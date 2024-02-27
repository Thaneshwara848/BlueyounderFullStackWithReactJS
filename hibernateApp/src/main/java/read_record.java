import entity.emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class read_record {
    public static void main(String[] args) {
        try{
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            emp e = (emp) em.find(emp.class, id);

            System.out.println(e.getUid());
            System.out.println(e.getName());
            System.out.println(e.getAge());
            System.out.println(e.getDesig());
            System.out.println(e.getSalary());
            tx.commit();

            System.out.println("Data Deleted....");
        }catch(Exception e){
            System.out.println(e);

        }
    }
}
