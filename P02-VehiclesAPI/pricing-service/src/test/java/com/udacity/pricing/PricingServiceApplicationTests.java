package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.repository.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	PriceRepository priceRepository;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testDBElementCount() {
		Iterable<Price> prices = priceRepository.findAll();

		assertThat(prices).isNotEmpty().hasSize(10);
		assertThat(prices).extracting("vehicleId").contains(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
	}

	@Test
	public void testGetPriceById() {
		ResponseEntity<Price> responseEntity = this.testRestTemplate.getForEntity("http://localhost:" + port + "/prices/1", Price.class);
		HttpStatus statusCode = responseEntity.getStatusCode();
		assertThat(statusCode.value()).isEqualTo(200);
		assertThat(responseEntity.getBody().getCurrency()).isEqualTo("USD");
		assertThat(responseEntity.getBody().getPrice()).isBetween(new BigDecimal(82735.35), new BigDecimal(82735.37));
		assertThat(responseEntity.getBody().getVehicleId()).isEqualTo(1L);
	}
}
