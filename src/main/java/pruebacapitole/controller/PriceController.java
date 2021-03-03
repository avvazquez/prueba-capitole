package pruebacapitole.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pruebacapitole.controller.domain.PriceRequest;
import pruebacapitole.service.PriceService;
import pruebacapitole.service.domain.PriceDTO;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class PriceController {

	private PriceService priceService;
	
	@GetMapping
	public PriceDTO getPrice(@Valid @RequestBody PriceRequest request) {
		return priceService.getPrice(request);
	}
}
