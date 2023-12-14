package com.d121211003.recipedb.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.d121211003.recipedb.utils.Constant.FOOD_TABLE

@Entity(tableName = FOOD_TABLE)
data class FoodEntity(
    @PrimaryKey
    var id: Int = 0,
    var title: String = "",
    var img: String = ""
)