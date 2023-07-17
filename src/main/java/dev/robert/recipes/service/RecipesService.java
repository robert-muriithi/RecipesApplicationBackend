package dev.robert.recipes.service;

import dev.robert.recipes.model.Recipe;
import dev.robert.recipes.repository.RecipesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RecipesService {

    @Autowired
    private RecipesRepository recipeRepo;


    public Recipe addRecipe(Recipe recipe) {
        try {
            return recipeRepo.save(recipe);
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

    public List<Recipe> getAllRecipes() {
        try {
            return recipeRepo.findAll();
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }
}
