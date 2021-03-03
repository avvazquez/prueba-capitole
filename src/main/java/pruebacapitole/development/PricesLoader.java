package pruebacapitole.development;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import pruebacapitole.repository.PriceRepository;
import pruebacapitole.repository.domain.Price;

@Component
public class PricesLoader {

	PriceRepository priceRepository;
	public PricesLoader(PriceRepository priceRepository) {
		
		priceRepository.saveAll(getData());
	}
	private List<Price> getData() {

		Function<String, LocalDateTime> dateParser = (String localDateTimeString) -> LocalDateTime
				.parse(localDateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss", Locale.ROOT));

		Price p1 = Price.builder()
				.brandId(1)
				.startDate(dateParser.apply("2020-06-14-00.00.00"))
				.endDate(dateParser.apply("2020-12-31-23.59.59"))
				.priceList(1)
				.productId(35455)
				.priority(0)
				.price(new BigDecimal("35.50"))
				.curr(Currency.getInstance("EUR"))
				.build();
		
		Price p2 = Price.builder()
				.brandId(1)
				.startDate(dateParser.apply("2020-06-14-15.00.00"))
				.endDate(dateParser.apply("2020-06-14-18.30.00"))
				.priceList(2)
				.productId(35455)
				.priority(1)
				.price(new BigDecimal("25.45"))
				.curr(Currency.getInstance("EUR"))
				.build();
		
		Price p3= Price.builder()
				.brandId(1)
				.startDate(dateParser.apply("2020-06-15-00.00.00"))
				.endDate(dateParser.apply("2020-06-15-11.00.00"))
				.priceList(3)
				.productId(35455)
				.priority(1)
				.price(new BigDecimal("30.50"))
				.curr(Currency.getInstance("EUR"))
				.build();
		
		Price p4 = Price.builder()
				.brandId(1)
				.startDate(dateParser.apply("2020-06-15-16.00.00"))
				.endDate(dateParser.apply("2020-12-31-23.59.59"))
				.priceList(4)
				.productId(35455)
				.priority(1)
				.price(new BigDecimal("38.95"))
				.curr(Currency.getInstance("EUR"))
				.build();
	
		return List.of(p1, p2, p3, p4);
	}
}
