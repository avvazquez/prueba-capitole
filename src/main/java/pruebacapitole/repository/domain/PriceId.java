package pruebacapitole.repository.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Id;

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
public class PriceId implements Serializable{

	private static final long serialVersionUID = 3142962448846117126L;
	
	@Id
	private Integer brandId;
	@Id
	@JsonSerialize( using = LocalDateTimeSerializer.class)
	@JsonDeserialize( using = LocalDateTimeDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
	private LocalDateTime startDate, endDate;
	@Id
	private Integer priceList;
	@Id
	private Integer productId;
}
