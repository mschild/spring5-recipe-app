package guru.springframework;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.service.RecipeServiceImpl;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;

	@Mock
	RecipeRepository recipeRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	public void testGetRecipes() {
		Recipe recipe = new Recipe();
		Set<Recipe> recipesData = new HashSet<>();

		recipesData.add(recipe);

		when(recipeRepository.findAll()).thenReturn(recipesData);

		Set<Recipe> recipes = recipeServiceImpl.getRecipes();

		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}

}
