package dev.robert.recipes.repository

import dev.robert.recipes.model.Recipe
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipesRepository : JpaRepository<Recipe, Long> {

}


