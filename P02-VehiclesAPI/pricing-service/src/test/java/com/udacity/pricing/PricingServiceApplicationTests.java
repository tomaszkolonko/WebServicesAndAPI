package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.repository.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PricingServiceApplicationTests {

	@Autowired
	PriceRepository priceRepository;

	@Test
	public void testDBElementCount() {
		Iterable<Price> prices = priceRepository.findAll();
		Price price = new Price("USD", new BigDecimal(82735.36), 1L);

		assertThat(prices).isNotEmpty().hasSize(10);
		assertThat(prices).extracting("vehicleId").contains(1L,2L,3L,4L,5L,6L,7L,8L,9L);
	}

	@Test
	public void testGetPriceById() {
		ResponseEntity<Price> responseEntity = null;
	}

}
