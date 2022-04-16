package com.team12.android_challenge_w6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team12.android_challenge_w6.movie.Movie
import com.team12.android_challenge_w6.restapi.RestClient
import kotlinx.coroutines.launch

class MovieViewModel:ViewModel() {
    var listNowPlaying =  MutableLiveData<List<Movie>?>()
    var listTopRated =  MutableLiveData<List<Movie>?>()
    fun getNowPlaying(){
        viewModelScope.launch {
            val movieResponse = RestClient.getInstance()
                    .API.listNowPlayMovies(
                            language = "en-US",
                            page = 1
                    )
            listNowPlaying.postValue(movieResponse.results!!)
        }
    }

    fun getTopRated(){
        viewModelScope.launch {
            val movieResponse = RestClient.getInstance()
                    .API.listTopRatedMovies(
                            language = "en-US",
                            page = 1
                    )
            listTopRated.postValue(movieResponse.results!!)
        }
    }
}