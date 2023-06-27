package dev.robert.recipes.controller

import dev.robert.recipes.model.Recipe
import dev.robert.recipes.repository.RecipesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/recipes")
class RecipesController(@Autowired private val recipeRepository: RecipesRepository) {

    @PostMapping("/add")
    fun addRecipe(@RequestBody recipe: Recipe): Recipe {
        return recipeRepository.save(recipe)
    }

    @GetMapping("/all")
    fun getAllRecipes(): List<Recipe> {
        return recipeRepository.findAll()
    }

}
