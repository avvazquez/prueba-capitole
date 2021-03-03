package pruebacapitole;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import lombok.AllArgsConstructor;
import pruebacapitole.controller.PriceController;
import pruebacapitole.controller.domain.PriceRequest;
import pruebacapitole.service.domain.PriceDTO;

@SpringBootTest
class PruebaCapitoleApplicationTests {

	private final Function<String, LocalDateTime> dateParser = (String localDateTimeString) -> LocalDateTime
			.parse(localDateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss", Locale.ROOT));
	
	@Autowired
	private PriceController priceController;
	
	@Test
	void contextLoads() {
		
		Assert.notNull(priceController, "El contexto no ha cargado");
	}
	
	@Test
	void testPrice1() {
		
		PriceRequest p1 = PriceRequest.builder()
				.brandId(1)
				.applyDate(dateParser.apply("2020-06-14-10.00.00"))
				.productId(35455)
				.build();
		
		PriceDTO priceDTO = priceController.getPrice(p1);
		Assert.isTrue(priceDTO.getPrice().equals(new BigDecimal("35.50")), "Precio erróneo");
	}
	
	@Test
	void testPrice2() {
		
		PriceRequest p1 = PriceRequest.builder()
				.brandId(1)
				.applyDate(dateParser.apply("2020-06-14-16.00.00"))
				.productId(35455)
				.build();
		
		PriceDTO priceDTO = priceController.getPrice(p1);
		Assert.isTrue(priceDTO.getPrice().equals(new BigDecimal("25.45")), "Precio erróneo");
	}
	
	@Test
	void testPrice3() {
		
		PriceRequest p1 = PriceRequest.builder()
				.brandId(1)
				.applyDate(dateParser.apply("2020-06-14-21.00.00"))
				.productId(35455)
				.build();
		
		PriceDTO priceDTO = priceController.getPrice(p1);
		Assert.isTrue(priceDTO.getPrice().equals(new BigDecimal("35.50")), "Precio erróneo");
	}
	
	@Test
	void testPrice4() {
		
		PriceRequest p1 = PriceRequest.builder()
				.brandId(1)
				.applyDate(dateParser.apply("2020-06-15-10.00.00"))
				.productId(35455)
				.build();
		
		PriceDTO priceDTO = priceController.getPrice(p1);
		Assert.isTrue(priceDTO.getPrice().equals(new BigDecimal("30.50")), "Precio erróneo");
	}
	
	@Test
	void testPrice5() {
		
		PriceRequest p1 = PriceRequest.builder()
				.brandId(1)
				.applyDate(dateParser.apply("2020-06-16-21.00.00"))
				.productId(35455)
				.build();
		
		PriceDTO priceDTO = priceController.getPrice(p1);
		Assert.isTrue(priceDTO.getPrice().equals(new BigDecimal("38.95")), "Precio erróneo");
	}

}
