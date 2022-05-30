package com.sergio994350.cookbook.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sergio994350.cookbook.entity.CategoryItems

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<CategoryItems>): String? {
        return if (category == null) {
            (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<CategoryItems>() {
            }.type
            gson.toJson(category, type)
        }
    }

    @TypeConverter
    fun toCategoryList(categoryString: String): List<CategoryItems>? {
        return if (categoryString == null) {
            (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<CategoryItems>() {
            }.type
            gson.fromJson(categoryString, type)
        }
    }
}