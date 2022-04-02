package com.team12.android_challenge_w4.activity.restaurant_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team12.android_challenge_w4.provider.getRestaurantList
import com.team12.android_challenge_w4.model.Restaurant

class RestaurantListViewModel : ViewModel(){

    private val restaurantList = MutableLiveData<List<Restaurant>>()

    fun fetchRestaurantList(): LiveData<List<Restaurant>>{
        restaurantList.value = getRestaurantList()
        return restaurantList
    }
}