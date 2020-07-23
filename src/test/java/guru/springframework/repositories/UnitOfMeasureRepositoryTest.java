package guru.springframework.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindByUom() {

		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByUom("Teaspoon");

		assertEquals("Teaspoon", uomOptional.get().getUom());
	}

	@Test
	public void testFindByUomCup() {

		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByUom("Cup");

		assertEquals("Cup", uomOptional.get().getUom());
	}

}
