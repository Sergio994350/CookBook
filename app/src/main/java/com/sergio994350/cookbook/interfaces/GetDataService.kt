package com.sergio994350.cookbook.interfaces

import com.sergio994350.cookbook.entity.Category
import com.sergio994350.cookbook.entity.Meal
import com.sergio994350.cookbook.entity.MealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>

    @GET("filter.php")
    fun getMealList(@Query("c") category: String): Call<Meal>

    @GET("lookup.php")
    fun getSpecificItem(@Query("i") id: String): Call<MealResponse>
}