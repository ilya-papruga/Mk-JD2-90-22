package core.dao.api;

import core.entity.Currency;
import org.hibernate.cfg.annotations.reflection.internal.JPAXMLOverriddenAnnotationReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ICurrencyDao extends JpaRepository <Currency, Long> {

    List<Currency> findByName (String name);

}
