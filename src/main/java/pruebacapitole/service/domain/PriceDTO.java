package pruebacapitole.service.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDTO {
	
	private Integer productId;
	private Integer brandId;
	private Integer priceList;
	@JsonSerialize( using = LocalDateTimeSerializer.class)
	@JsonDeserialize( using = LocalDateTimeDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
	private LocalDateTime startDate, endDate;
	private BigDecimal price;
	private Currency currency;
}
