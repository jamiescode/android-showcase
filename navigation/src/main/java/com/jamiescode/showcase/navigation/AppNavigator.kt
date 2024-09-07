package com.jamiescode.showcase.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object AppNavigator {
    private val navigationEventsMutableLiveData: MutableLiveData<Destinations> by lazy {
        MutableLiveData<Destinations>(Destinations.Nowhere)
    }
    val navigationEventsLiveData = navigationEventsMutableLiveData as LiveData<Destinations>

    fun navigateTo(destinations: Destinations) {
        navigationEventsMutableLiveData.postValue(destinations)
    }
}
