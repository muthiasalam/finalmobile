package com.d121211003.recipedb.api

import com.d121211003.recipedb.response.CategoriesListResponse
import com.d121211003.recipedb.response.FoodsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {


    @GET("random.php")
     suspend fun getFoodRandom() : Response<FoodsListResponse>

    @GET("categories.php")
    suspend fun getCategoriesList() : Response<CategoriesListResponse>

    @GET("search.php")
    suspend fun getFoodList(@Query("f") latter : String) : Response<FoodsListResponse>

    @GET("search.php")
    suspend fun searchList(@Query("s") latter : String) : Response<FoodsListResponse>

    @GET("filter.php")
    suspend fun filterList(@Query("c") latter : String) : Response<FoodsListResponse>

    @GET("lookup.php")
    suspend fun getFoodDetails(@Query("i") id : Int) : Response<FoodsListResponse>
}