package pruebacapitole.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pruebacapitole.controller.domain.PriceRequest;
import pruebacapitole.repository.PriceRepository;
import pruebacapitole.repository.domain.Price;
import pruebacapitole.service.domain.PriceDTO;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService{

	PriceRepository priceRepository;
	
	@Override
	public PriceDTO getPrice(@Valid PriceRequest request) {
		 Price price = priceRepository.getPrice(request.getApplyDate(), request.getBrandId(), request.getProductId());
		 return price == null ? null : PriceDTO.builder()
				 .brandId(price.getBrandId())
				 .currency(price.getCurr())
				 .endDate(price.getEndDate())
				 .price(price.getPrice())
				 .priceList(price.getPriceList())
				 .productId(price.getProductId())
				 .startDate(price.getStartDate())
				 .build();
	}
}
