package tacos.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.data.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

	private IngredientRepository ingredientRepo;

	// @Autowired "Warning: Unnecessary @Autowired
	public IngredientByIdConverter(IngredientRepository aIingredientRepo) {
		this.ingredientRepo = aIingredientRepo;
	}

	@Override
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);
	}

}
