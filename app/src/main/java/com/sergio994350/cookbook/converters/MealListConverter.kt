package com.sergio994350.cookbook.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sergio994350.cookbook.entity.MealsItems

class MealListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<MealsItems>): String? {
        return if (category == null) {
            (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<MealsItems>() {

            }.type
            gson.toJson(category, type)
        }
    }

    @TypeConverter
    fun toCategoryList(categoryString: String): List<MealsItems>? {
        return if (categoryString == null) {
            (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<MealsItems>() {

            }.type
            gson.fromJson(categoryString, type)
        }
    }
}