package org.example.core.dao.api;

import org.example.core.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICurrencyDao extends JpaRepository <Currency, Long> {

    List<Currency> findByName (String name);

}
