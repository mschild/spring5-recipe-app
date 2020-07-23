package guru.springframework.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {

	private final RecipeRepository recipeRepository;
	private final CategoryRepository categoryRepository;

	public BootstrapData(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Recipe perfectGuacamole = new Recipe();
		perfectGuacamole.setCookTime(0);
		perfectGuacamole.setDescription(
				"The best guacamole keeps it simple: just ripe avocados, salt, a squeeze of lime, onions, chiles, cilantro, and some chopped tomato. Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.");
		perfectGuacamole.setDifficulty(Difficulty.EASY);

		perfectGuacamole.setPrepTime(10);
		perfectGuacamole.setServings(2);
		perfectGuacamole.setSource("simplerecipes");
		perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

		Category category = new Category();
		category.setDescription("Dips");
		this.categoryRepository.save(category);

		UnitOfMeasure teaspoon = new UnitOfMeasure();
		teaspoon.setUom("teaspoon");
		UnitOfMeasure tablespoon = new UnitOfMeasure();
		tablespoon.setUom("tablespoon");
		UnitOfMeasure dash = new UnitOfMeasure();
		dash.setUom("dash");

		Ingredient avocado = new Ingredient();
		avocado.setDescription("ripe avodados");
		avocado.setAmount(BigDecimal.valueOf(2));
		avocado.setRecipe(perfectGuacamole);
		Ingredient salt = new Ingredient();
		salt.setDescription("salt");
		salt.setAmount(BigDecimal.valueOf(0.25));
		salt.setRecipe(perfectGuacamole);

		Notes note1 = new Notes();
		note1.setRecipeNotes(
				"1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\r\n"
						+ "\r\n"
						+ "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\r\n"
						+ "\r\n"
						+ "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\r\n"
						+ "\r\n"
						+ "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\r\n"
						+ "\r\n"
						+ "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\r\n"
						+ "\r\n"
						+ "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\r\n"
						+ "\r\n"
						+ "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\r\n"
						+ "");

		perfectGuacamole.addIngredient(avocado);
		perfectGuacamole.addIngredient(salt);
		perfectGuacamole.setNotes(note1);
		perfectGuacamole.addCategory(category);

		this.recipeRepository.save(perfectGuacamole);

	}

}
