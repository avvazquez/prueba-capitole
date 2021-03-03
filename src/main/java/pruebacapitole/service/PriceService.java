package pruebacapitole.service;

import org.springframework.stereotype.Service;

import pruebacapitole.controller.domain.PriceRequest;
import pruebacapitole.service.domain.PriceDTO;

@Service
public interface PriceService {

	PriceDTO getPrice(PriceRequest request);
}
