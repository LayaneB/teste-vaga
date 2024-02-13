package org.rethink.challenge.repository;

import org.rethink.challenge.model.CurrencyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyModel, Long> {

    Optional<CurrencyModel> findCurrencyModelByLabel(String label);
}
