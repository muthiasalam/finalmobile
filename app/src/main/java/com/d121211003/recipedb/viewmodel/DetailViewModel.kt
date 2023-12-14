package com.d121211003.recipedb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d121211003.recipedb.db.FoodEntity
import com.d121211003.recipedb.repository.MainRepository
import com.d121211003.recipedb.response.FoodsListResponse
import com.d121211003.recipedb.utils.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val _foodDetailData: MutableLiveData<DataStatus<FoodsListResponse>> = MutableLiveData()
    val foodDetailData: LiveData<DataStatus<FoodsListResponse>>
        get() = _foodDetailData

    fun loadFoodDetail(id: Int) = viewModelScope.launch {
        repository.getFoodDetail(id).collect { _foodDetailData.value = it }
    }

    fun saveFood(entity: FoodEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveFood(entity)
    }

    fun deleteFood(entity: FoodEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteFood(entity)
    }

    val isFavoriteData = MutableLiveData<Boolean>()
    fun existsFood(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.existsFood(id).collect { isFavoriteData.postValue(it) }
    }
}