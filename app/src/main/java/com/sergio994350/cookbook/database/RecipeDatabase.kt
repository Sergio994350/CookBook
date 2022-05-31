package com.sergio994350.cookbook.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sergio994350.cookbook.DB_NAME
import com.sergio994350.cookbook.converters.CategoryListConverter
import com.sergio994350.cookbook.converters.MealListConverter
import com.sergio994350.cookbook.dao.RecipeDao
import com.sergio994350.cookbook.entity.Recipes
import com.sergio994350.cookbook.entity.CategoryItems
import com.sergio994350.cookbook.entity.Category
import com.sergio994350.cookbook.entity.Meal
import com.sergio994350.cookbook.entity.MealsItems


@Database(
    entities = [Recipes::class, CategoryItems::class, Category::class, Meal::class, MealsItems::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CategoryListConverter::class, MealListConverter::class)
abstract class RecipeDatabase : RoomDatabase() {

    companion object {
        var recipesDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase {
            if (recipesDatabase == null) {
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    DB_NAME
                ).build()
            }
            return recipesDatabase!!
        }
    }
    abstract fun recipeDao(): RecipeDao
}