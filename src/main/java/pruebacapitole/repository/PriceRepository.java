package pruebacapitole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebacapitole.repository.domain.Price;
import pruebacapitole.repository.domain.PriceId;

public interface PriceRepository extends JpaRepository<Price, PriceId>, PriceRepositoryCustom {

}
