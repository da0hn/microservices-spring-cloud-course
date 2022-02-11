package org.da0hn.cambio.data.db;

import org.da0hn.cambio.core.domain.CambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCambioRepository extends JpaRepository<CambioEntity, Long> {

  Optional<CambioEntity> findCambioEntityByFromAndTo(String from, String to);

}
