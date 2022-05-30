import dao.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainInsert {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("dao.entity");

        EntityManager entityManager = sessionFactory.createEntityManager();

        Event event = new Event();

     // Event event = entityManager.find(Event.class, 1);
     // event.setTitle("Новый тайтл 100500");
      event.setId(4l);

        entityManager.getTransaction().begin();

      entityManager.persist(event);

      // entityManager.persist(new Event( "Our very first event!", LocalDateTime.now() ));
      // entityManager.persist(new Event( "A follow up event", LocalDateTime.now() ) );

        entityManager.getTransaction().commit();



        entityManager.close();
    }

}
