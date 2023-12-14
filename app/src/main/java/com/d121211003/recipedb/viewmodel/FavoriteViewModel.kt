package com.d121211003.recipedb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d121211003.recipedb.db.FoodEntity
import com.d121211003.recipedb.repository.MainRepository
import com.d121211003.recipedb.utils.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {


    private val _foodList: MutableLiveData<DataStatus<List<FoodEntity>>> = MutableLiveData()
    val foodList: LiveData<DataStatus<List<FoodEntity>>>
        get() = _foodList

    fun getFavoritesFoodList() = viewModelScope.launch {
        repository.getDbFoodList().collect {
            _foodList.value=DataStatus.success(it)
        }
    }
}