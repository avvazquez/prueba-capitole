package pruebacapitole.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;

import pruebacapitole.repository.domain.Price;

public interface PriceRepositoryCustom {

	@Query(value = "SELECT TOP 1 * FROM PRICE WHERE BRAND_ID = ?2 AND PRODUCT_ID = ?3 AND ?1 BETWEEN START_DATE AND END_DATE ORDER BY PRIORITY DESC", nativeQuery = true)
	Price getPrice(LocalDateTime applyDate, Integer brandId, Integer productId);
}
