package pruebacapitole.repository.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(PriceId.class)
public class Price {

	@Id
	private Integer brandId;
	@JsonSerialize( using = LocalDateTimeSerializer.class)
	@JsonDeserialize( using = LocalDateTimeDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
	private LocalDateTime startDate, endDate;
	@Id
	private Integer priceList;
	@Id
	private Integer productId;
	private Integer priority;
	private BigDecimal price;
	private Currency curr;
}
