package relation.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {


        EntityManagerFactory departmentFactory = Persistence.createEntityManagerFactory("relation.one_to_one.Department");

        EntityManager entityManager = departmentFactory.createEntityManager();

        Department department = new Department("Колхоз 777");

        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
        entityManager.close();

/*
        EntityManagerFactory employeeFactory = Persistence.createEntityManagerFactory("relation.one_to_one.Employee");

        EntityManager entityManager2 = employeeFactory.createEntityManager();

        Employee employee = new Employee();

        entityManager2.getTransaction().begin();
        employee.setName("9999");
        employee.setDepartment(department);

        entityManager2.persist(employee);
        entityManager2.getTransaction().commit();
        entityManager2.close();
*/

    }
}
