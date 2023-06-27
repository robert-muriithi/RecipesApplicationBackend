package dev.robert.recipes.service

import dev.robert.recipes.repository.RecipesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import dev.robert.recipes.model.Recipe


@Service
class RecipesService(@Autowired private val recipeRepository: RecipesRepository) {
        fun getAllRecipes(): MutableList<Recipe> = recipeRepository.findAll()
        fun addRecipe(recipe: Recipe): Recipe = recipeRepository.save(recipe)
}