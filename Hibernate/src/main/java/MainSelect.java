import dao.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

public class MainSelect {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("dao.entity");

        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Event> result = entityManager.createQuery("from Event", Event.class).getResultList();
        for (Event event : result) {
            System.out.println("Event (" + event.getDtEvent() + ") : " + event.getTitle());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
