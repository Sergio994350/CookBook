package com.sergio994350.cookbook.interfaces

import com.sergio994350.cookbook.CATEGORIES_EP
import com.sergio994350.cookbook.FILTER_EP
import com.sergio994350.cookbook.LOOKUP_EP
import com.sergio994350.cookbook.entity.Category
import com.sergio994350.cookbook.entity.Meal
import com.sergio994350.cookbook.entity.MealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataService {
    @GET(CATEGORIES_EP)
    fun getCategoryList(): Call<Category>

    @GET(FILTER_EP)
    fun getMealList(@Query("c") category: String): Call<Meal>

    @GET(LOOKUP_EP)
    fun getSpecificItem(@Query("i") id: String): Call<MealResponse>
}